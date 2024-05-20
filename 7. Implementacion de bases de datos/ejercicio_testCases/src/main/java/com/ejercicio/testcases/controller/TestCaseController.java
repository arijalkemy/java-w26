package com.ejercicio.testcases.controller;

import com.ejercicio.testcases.dto.PostResponseDTO;
import com.ejercicio.testcases.dto.PostRequestDTO;
import com.ejercicio.testcases.dto.TestCaseDTO;
import com.ejercicio.testcases.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<PostResponseDTO> createTestCase(@RequestBody PostRequestDTO postRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
            testCaseService.createTestCase(postRequestDTO)
        );
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases() {
        return ResponseEntity.status(HttpStatus.OK).body(
            testCaseService.getAllTestCases()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseBtId(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                testCaseService.getTestCaseById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable long id, @RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
            testCaseService.updateTestCaseById(id, testCaseDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCaseById(@PathVariable long id) {
        testCaseService.deleteTestCaseById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(params = "last_update")
    public ResponseEntity<List<TestCaseDTO>> getAllByLastUpdate(@RequestParam(name = "last_update") String lastUpdate) {
        return ResponseEntity.status(HttpStatus.OK).body(
            testCaseService.getAllByLastUpdate(lastUpdate)
        );
    }
}
