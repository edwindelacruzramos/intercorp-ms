package pe.intecorp.ms01.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "person_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String city;
    private String country;
    private String firstname2;
    private String lastname2;
    private String email;

    private Integer random;

    @Column(name = "random_float")
    private Double randomFloat;

    private Boolean bool;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "reg_ex", columnDefinition = "TEXT")
    private String regEx;

    @Column(name = "enum_value")
    private String enumValue;

    private Integer age;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonElt> elts;
}
