package pe.intecorp.ms01.dto;

import lombok.Data;
import pe.intecorp.ms01.model.PersonElt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DataRecordDTO {
    private PersonDTO person;
    private int random;
    private double randomFloat;
    private boolean bool;
    private LocalDate date;
    private String regEx;
    private String enumValue;
    private List<String> elt;
    private Integer age;

    @Data
    public static class PersonDTO {
        private String firstname;
        private String lastname;
        private String city;
        private String country;
        private String firstname2;
        private String lastname2;
        private String email;
    }
}