package jpa.qatestersvivo.controller;

import jpa.qatestersvivo.model.TestCase;
import jpa.qatestersvivo.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase) {
        TestCase savedTestCase = testCaseService.createTestCase(testCase);
        return new ResponseEntity<>(savedTestCase, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TestCase> getAllTestCases() {
        return testCaseService.getAllTestCases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        TestCase testCase = testCaseService.getTestCaseById(id);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable Long id, @RequestBody TestCase updatedTestCase) {
        TestCase testCase = testCaseService.updateTestCase(id, updatedTestCase);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(params = "last_update")
    public List<TestCase> getTestCasesByLastUpdate(@RequestParam("last_update") String lastUpdate) {
        return testCaseService.getTestCasesByLastUpdate(lastUpdate);
    }

}
