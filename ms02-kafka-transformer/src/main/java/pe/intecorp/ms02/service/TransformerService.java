package pe.intecorp.ms02.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.intecorp.ms02.dto.DataRecordDTO;
import pe.intecorp.ms02.kafka.KafkaProducer;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransformerService {

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;

    public void process(String message) {
        try {
            DataRecordDTO dto = objectMapper.readValue(message, DataRecordDTO.class);
            dto.setCreatedAt(LocalDateTime.now());
            String newMessage = objectMapper.writeValueAsString(dto);
            kafkaProducer.send(newMessage);
            log.info("Mensaje reenviado a Kafka 02: {}", newMessage);
        } catch (Exception e) {
            log.error("Error procesando mensaje en MS02", e);
        }
    }
}