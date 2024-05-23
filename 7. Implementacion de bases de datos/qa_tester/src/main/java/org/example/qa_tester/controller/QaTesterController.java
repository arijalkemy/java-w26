package org.example.qa_tester.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.example.qa_tester.dtos.ReqTestCaseDto;
import org.example.qa_tester.dtos.SuccessDto;
import org.example.qa_tester.dtos.TestCaseDto;
import org.example.qa_tester.service.IQaTesterService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testcases")
public class QaTesterController {
    private final IQaTesterService service;

    @PostMapping("/new")
    public ResponseEntity<SuccessDto> createTestCase(
            @RequestBody @Valid ReqTestCaseDto testCaseDto
    ) {
        SuccessDto response = service.createTestCase(testCaseDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TestCaseDto>> getAllTestCases() {
        List<TestCaseDto> response = service.getAllTestCases();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) {
        TestCaseDto response = service.getTestCaseById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(
            @PathVariable Long id,
            @RequestBody @Valid ReqTestCaseDto testCaseDto
    ) {
        TestCaseDto response = service.updateTestCase(id, testCaseDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessDto> deleteTestCase(@PathVariable Long id) {
        SuccessDto response = service.deleteTestCase(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDto>> getTestCasesByDate(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") @Valid Date last_update
    ) {
        List<TestCaseDto> response = service.getTestCasesByDate(last_update);
        return ResponseEntity.ok(response);
    }
}
