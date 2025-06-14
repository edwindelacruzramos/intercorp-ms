package pe.intecorp.ms04.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import pe.intecorp.ms04.service.PersonRecordService;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class PersonRecordController {

    @Autowired
    private PersonRecordService personRecordService;

    @GetMapping
    public ResponseEntity<?> getAllData() {
        return ResponseEntity.ok(personRecordService.getConsolidatedData());
    }
}
