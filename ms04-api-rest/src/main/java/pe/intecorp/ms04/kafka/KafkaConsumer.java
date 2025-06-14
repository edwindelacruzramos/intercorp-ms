package pe.intecorp.ms04.kafka;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.intecorp.ms04.service.PersonRecordService;

import java.util.Map;

@Slf4j
@Component
public class KafkaConsumer {

    private final PersonRecordService personRecordService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumer(PersonRecordService personRecordService) {
        this.personRecordService = personRecordService;
    }

    @KafkaListener(topics = "${app.kafka-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        try {
            Map<String, Object> payload = objectMapper.readValue(message, new TypeReference<>() {});
            personRecordService.saveFromKafka(payload);
            log.info("[MS04] Mensaje guardado correctamente desde kafka-topic-02");
        } catch (Exception e) {
            log.error("[MS04] Error al procesar mensaje Kafka", e);
        }
    }
}
