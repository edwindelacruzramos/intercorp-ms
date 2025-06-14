package pe.intecorp.ms05.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.intecorp.ms05.dto.DataRecordDTO;
import pe.intecorp.ms05.model.DataRecord;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${app.kafka-topic}")
    private String topic;

    public void sendToKafka(DataRecord record) {
        try {
            DataRecordDTO dto = DataRecordDTO.toEntity(record);
            String json = objectMapper.writeValueAsString(dto);

//            log.info("Message to sent to Kafka topic: {}", new ObjectMapper()
//                    .writerWithDefaultPrettyPrinter().writeValueAsString(dto));

            kafkaTemplate.send(topic, json).whenComplete((res, ex) -> {
                if (ex != null) {
                    log.error("Error al enviar a Kafka: {}", ex.getMessage(), ex);
                } else {
                    //log.info("Mensaje enviado al tópico {}: {}", topic, json);
                }
            });

        } catch (Exception e) {
            log.error("Error procesando el mensaje antes de enviar a Kafka", e);
            throw new RuntimeException("Error al enviar a Kafka", e);
        }
    }
}
