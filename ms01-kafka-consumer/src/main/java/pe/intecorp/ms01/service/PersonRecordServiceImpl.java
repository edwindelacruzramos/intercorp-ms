package pe.intecorp.ms01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.intecorp.ms01.model.PersonRecord;
import pe.intecorp.ms01.repository.PersonRecordRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonRecordServiceImpl implements PersonRecordService {

    private final PersonRecordRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<PersonRecord> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public PersonRecord save(PersonRecord person) {
        return repository.save(person);
    }

    @Override
    @Transactional
    public Optional<PersonRecord> update(Long id, PersonRecord person) {
        return repository.findById(id).map(existing -> {
            existing.setFirstname(person.getFirstname());
            existing.setLastname(person.getLastname());
            existing.setCity(person.getCity());
            existing.setCountry(person.getCountry());
            existing.setFirstname2(person.getFirstname2());
            existing.setLastname2(person.getLastname2());
            existing.setEmail(person.getEmail());
            existing.setRandom(person.getRandom());
            existing.setRandomFloat(person.getRandomFloat());
            existing.setBool(person.getBool());
            existing.setDate(person.getDate());
            existing.setRegEx(person.getRegEx());
            existing.setEnumValue(person.getEnumValue());
            existing.setAge(person.getAge());
            return repository.save(existing);
        });
    }

    @Override
    @Transactional
    public Optional<PersonRecord> delete(Long id) {
        return repository.findById(id).map(record -> {
            repository.delete(record);
            return record;
        });
    }
}