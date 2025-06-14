package pe.intecorp.ms04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.intecorp.ms04.model.PersonElt;

public interface PersonEltRepository extends JpaRepository<PersonElt, Long> {
}
