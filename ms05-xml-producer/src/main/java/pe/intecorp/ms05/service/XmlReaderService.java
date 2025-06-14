package pe.intecorp.ms05.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import pe.intecorp.ms05.model.DataRecord;

import java.io.File;

@Service
public class XmlReaderService {

    public DataRecord readXml(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataRecord.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (DataRecord) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer XML: " + file.getName(), e);
        }
    }
}
