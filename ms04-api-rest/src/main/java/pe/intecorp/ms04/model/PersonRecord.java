package pe.intecorp.ms04.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "person_record")
@Data
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
    private Double randomFloat;
    private Boolean bool;
    private Date date;
    @Column(columnDefinition = "TEXT")
    private String regEx;
    private String enumValue;
    private Integer age;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
