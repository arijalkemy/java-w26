package org.example.ejercicioqatester.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.example.ejercicioqatester.dto.TestCaseDTO;
import org.example.ejercicioqatester.dto.TestCaseToUpdateDTO;
import org.example.ejercicioqatester.model.TestCase;
import org.example.ejercicioqatester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {
    @Autowired
    private ITestCaseService service;

    @PostMapping("/testcases/new")
    public ResponseEntity<TestCaseDTO> saveTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveTestCase(testCaseDTO));
    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTestCases());
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getTestCaseById(id));
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<Void> updateTestCase(@PathVariable Long id,@RequestBody TestCaseToUpdateDTO testCaseDTO){
        service.updateTestCase(id,
                testCaseDTO.getDescription(),
                testCaseDTO.getTested(),
                testCaseDTO.getPassed(),
                testCaseDTO.getNumber_of_tries(),
                testCaseDTO.getLast_update());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        service.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/testcases/by-date")
    public ResponseEntity<List<TestCaseDTO>> getTestCasesByDate(@RequestParam String last_update) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getTestCasesByDate(last_update));
    }

}
