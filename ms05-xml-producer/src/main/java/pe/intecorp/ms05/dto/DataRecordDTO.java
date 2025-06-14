package pe.intecorp.ms05.dto;

import lombok.Data;
import org.w3c.dom.Element;
import pe.intecorp.ms05.model.DataRecord;
import pe.intecorp.ms05.model.Person;

import java.util.List;

@Data
public class DataRecordDTO {

    private Person person;
    private int random;
    private double randomFloat;
    private boolean bool;
    private String date;
    private String regEx;
    private String enumValue;
    private List<String> elt;
    private Integer age;

    public static DataRecordDTO toEntity(DataRecord record) {
        DataRecordDTO dto = new DataRecordDTO();
        dto.setPerson(record.getPerson());
        dto.setRandom(record.getRandom());
        dto.setRandomFloat(record.getRandomFloat());
        dto.setBool(record.isBool());
        dto.setDate(record.getDate());
        dto.setRegEx(record.getRegEx());
        dto.setEnumValue(record.getEnumValue());
        dto.setElt(record.getElt());
        dto.setAge(extractDynamicAge(record));
        return dto;
    }

    private static Integer extractDynamicAge(DataRecord record) {
        if (record.getOthers() == null || record.getPerson() == null) return null;
        for (Element el : record.getOthers()) {
            if (el.getTagName().equals(record.getPerson().getFirstname2())) {
                try {
                    String ageStr = el.getElementsByTagName("age").item(0).getTextContent();
                    return Integer.parseInt(ageStr);
                } catch (Exception ignored) {}
            }
        }
        return null;
    }
}
