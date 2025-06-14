package pe.intecorp.ms02.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka-topic-output}")
    private String kafkaTopicOut;

    public void send(String message) {
        kafkaTemplate.send(kafkaTopicOut, message);
    }
}