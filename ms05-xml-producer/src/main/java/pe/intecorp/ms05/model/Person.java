package pe.intecorp.ms05.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute
    private String firstname;

    @XmlAttribute
    private String lastname;

    @XmlAttribute
    private String city;

    @XmlAttribute
    private String country;

    @XmlAttribute
    private String firstname2;

    @XmlAttribute
    private String lastname2;

    @XmlAttribute
    private String email;
}
