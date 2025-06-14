package pe.intecorp.ms01.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.intecorp.ms01.dto.DataRecordDTO;
import pe.intecorp.ms01.model.PersonElt;
import pe.intecorp.ms01.model.PersonRecord;
import pe.intecorp.ms01.service.PersonRecordService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final PersonRecordService service;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${app.kafka-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        try {
            log.info("Mensaje recibido desde Kafka: {}", message);
            DataRecordDTO dto = objectMapper.readValue(message, DataRecordDTO.class);

            PersonRecord entity = new PersonRecord();
            entity.setFirstname(dto.getPerson().getFirstname());
            entity.setLastname(dto.getPerson().getLastname());
            entity.setCity(dto.getPerson().getCity());
            entity.setCountry(dto.getPerson().getCountry());
            entity.setFirstname2(dto.getPerson().getFirstname2());
            entity.setLastname2(dto.getPerson().getLastname2());
            entity.setEmail(dto.getPerson().getEmail());

            entity.setRandom(dto.getRandom());
            entity.setRandomFloat(dto.getRandomFloat());
            entity.setBool(dto.isBool());
            entity.setDate(dto.getDate());
            entity.setRegEx(dto.getRegEx());
            entity.setEnumValue(dto.getEnumValue());
            entity.setAge(dto.getAge());
            entity.setCreatedAt(LocalDateTime.now());

            // Convierte List<String> a List<PersonElt>
            List<PersonElt> eltEntities = dto.getElt().stream()
                    .map(value -> {
                        PersonElt elt = new PersonElt();
                        elt.setEltValue(value);
                        elt.setPerson(entity); // Enlaza la relación
                        return elt;
                    })
                    .toList();

            entity.setElts(eltEntities);

            service.save(entity);
            log.info("Guardado en base de datos: {}", entity);
        } catch (Exception e) {
            log.error("Error al procesar mensaje Kafka", e);
        }
    }
}
