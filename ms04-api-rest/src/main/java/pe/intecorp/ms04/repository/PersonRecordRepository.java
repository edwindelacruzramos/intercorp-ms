package pe.intecorp.ms04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.intecorp.ms04.model.PersonRecord;

public interface PersonRecordRepository extends JpaRepository<PersonRecord, Long> {
}
