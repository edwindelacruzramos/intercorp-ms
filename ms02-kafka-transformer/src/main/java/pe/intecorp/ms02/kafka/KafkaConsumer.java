package pe.intecorp.ms02.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.intecorp.ms02.service.TransformerService;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final TransformerService transformerService;

    @KafkaListener(topics = "${app.kafka-topic-input}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("Mensaje recibido en MS02: {}", message);
        transformerService.process(message);
    }
}