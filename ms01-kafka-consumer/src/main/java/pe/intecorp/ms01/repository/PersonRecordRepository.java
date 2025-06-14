package pe.intecorp.ms01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.intecorp.ms01.model.PersonRecord;

public interface PersonRecordRepository extends JpaRepository<PersonRecord, Long> {
}
