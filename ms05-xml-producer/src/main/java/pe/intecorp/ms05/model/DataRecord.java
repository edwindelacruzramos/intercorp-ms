package pe.intecorp.ms05.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import org.w3c.dom.Element;

import java.util.List;

@Data
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataRecord {

    @XmlElement(name = "random")
    private int random;

    @XmlElement(name = "random_float")
    private double randomFloat;

    @XmlElement(name = "bool")
    private boolean bool;

    @XmlElement(name = "date")
    private String date;

    @XmlElement(name = "regEx")
    private String regEx;

    @XmlElement(name = "enum")
    private String enumValue;

    @XmlElement(name = "person")
    private Person person;

    @XmlElement(name = "elt")
    private List<String> elt;

    @XmlAnyElement(lax = true)
    private List<Element> others;
}
