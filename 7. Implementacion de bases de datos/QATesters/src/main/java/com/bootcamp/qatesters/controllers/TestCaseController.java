package com.bootcamp.qatesters.controllers;

import com.bootcamp.qatesters.dtos.TestCaseRequestDTO;
import com.bootcamp.qatesters.dtos.TestCaseResponseDTO;
import com.bootcamp.qatesters.services.TestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseResponseDTO> postTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.createTestCase(testCaseRequestDTO));
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseResponseDTO>> getAll() {
        return ResponseEntity.ok(testCaseService.getAllTestCases());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getAll(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getById(id));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<TestCaseResponseDTO>> getAll(@PathVariable LocalDate date) {
        return ResponseEntity.ok(testCaseService.getByDate(date));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> update(@PathVariable Long id,
                                                      @RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCaseRequestDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }
}
