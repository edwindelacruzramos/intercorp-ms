package pe.intecorp.ms01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.intecorp.ms01.model.PersonElt;

public interface PersonEltRepository extends JpaRepository<PersonElt, Long> {
}
