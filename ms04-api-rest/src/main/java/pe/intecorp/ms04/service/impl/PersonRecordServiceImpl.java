package pe.intecorp.ms04.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.intecorp.ms04.model.PersonElt;
import pe.intecorp.ms04.model.PersonRecord;
import pe.intecorp.ms04.repository.PersonEltRepository;
import pe.intecorp.ms04.repository.PersonRecordRepository;
import pe.intecorp.ms04.service.PersonRecordService;
import java.util.*;

@Service
public class PersonRecordServiceImpl implements PersonRecordService {

    @Autowired
    private PersonRecordRepository repository;

    @Autowired
    private PersonEltRepository eltRepository;

    @Override
    public Map<String, Object> getConsolidatedData() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", repository.findAll());
        result.put("lastUpdate", new Date());
        return result;
    }

    @Override
    public void saveFromKafka(Map<String, Object> message) {
        Map<String, Object> personMap = (Map<String, Object>) message.get("person");

        PersonRecord person = new PersonRecord();
        person.setFirstname((String) personMap.get("firstname"));
        person.setLastname((String) personMap.get("lastname"));
        person.setCity((String) personMap.get("city"));
        person.setCountry((String) personMap.get("country"));
        person.setFirstname2((String) personMap.get("firstname2"));
        person.setLastname2((String) personMap.get("lastname2"));
        person.setEmail((String) personMap.get("email"));
        person.setRandom((Integer) message.get("random"));
        person.setRandomFloat(((Number) message.get("randomFloat")).doubleValue());
        person.setBool((Boolean) message.get("bool"));
        person.setDate(java.sql.Date.valueOf((String) message.get("date")));
        person.setRegEx((String) message.get("regEx"));
        person.setEnumValue((String) message.get("enumValue"));
        person.setAge((Integer) message.get("age"));

        String createdAtStr = (String) message.get("createdAt");
        person.setCreatedAt(java.sql.Timestamp.valueOf(createdAtStr.replace("T", " ").substring(0, 23)));

        person = repository.save(person);

        // Procesa la lista "elt"
        List<String> elts = (List<String>) message.get("elt");
        if (elts != null) {
            for (String value : elts) {
                PersonElt elt = new PersonElt();
                elt.setPerson(person);
                elt.setEltValue(value);
                eltRepository.save(elt);
            }
        }
    }
}
