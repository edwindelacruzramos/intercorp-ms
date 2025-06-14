package pe.intecorp.ms04.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person_elt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonElt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "elt_value")
    private String eltValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private PersonRecord person;
}
