package org.ggomezr.qatesters.application.controller;

import org.ggomezr.qatesters.application.service.impl.TestCaseService;
import org.ggomezr.qatesters.domain.dto.TestCaseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTestCases(){
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.updatedTestCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> getTestCasesByUpdatedDate(@RequestParam("last_update") LocalDate lastUpdate){
        return new ResponseEntity<>(testCaseService.getTestCasesAfterLastUpdateDate(lastUpdate), HttpStatus.OK);
    }
}
