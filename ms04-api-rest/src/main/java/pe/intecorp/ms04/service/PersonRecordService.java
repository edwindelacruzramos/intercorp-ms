package pe.intecorp.ms04.service;

import java.util.Map;

public interface PersonRecordService {
    Map<String, Object> getConsolidatedData();
    void saveFromKafka(Map<String, Object> message);
}
