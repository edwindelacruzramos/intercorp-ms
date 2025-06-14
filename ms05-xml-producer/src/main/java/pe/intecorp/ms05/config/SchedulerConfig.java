package pe.intecorp.ms05.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pe.intecorp.ms05.model.DataRecord;
import pe.intecorp.ms05.service.KafkaProducerService;
import pe.intecorp.ms05.service.XmlReaderService;

import java.io.File;

@Slf4j
@Component
@RequiredArgsConstructor
public class SchedulerConfig {

    private final XmlReaderService xmlReaderService;
    private final KafkaProducerService kafkaProducerService;

    @Value("${app.xml-path}")
    private String xmlFolderPath;

    @Scheduled(fixedRate = 180000) // cada 3 minutos
    //@Scheduled(fixedRate = 10000) // cada 10 segundos (solo para pruebas)
    public void readAndSendXml() {
        log.info("Ejecutando tarea programada a las {}", java.time.LocalDateTime.now());

        File folder = new File(xmlFolderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".xml"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                try {
                    DataRecord record = xmlReaderService.readXml(file);
                    kafkaProducerService.sendToKafka(record);
                } catch (Exception e) {
                    log.error("Error leyendo el archivo XML: {}", file.getName(), e);
                }
            }
        } else {
            log.warn("No se encontraron archivos XML en la carpeta: {}", folder.getAbsolutePath());
        }
    }
}
