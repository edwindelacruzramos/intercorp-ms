package pe.intecorp.ms01.service;

import pe.intecorp.ms01.model.PersonRecord;

import java.util.List;
import java.util.Optional;

public interface PersonRecordService {
    //void consume(String message);
    List<PersonRecord> findAll();
    Optional<PersonRecord> findById(Long id);
    PersonRecord save(PersonRecord person);
    Optional<PersonRecord> update(Long id, PersonRecord person);
    Optional<PersonRecord> delete(Long id);
}
