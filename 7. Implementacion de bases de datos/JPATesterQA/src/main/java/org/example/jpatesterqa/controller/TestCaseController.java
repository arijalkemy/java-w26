package org.example.jpatesterqa.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.Valid;
import org.example.jpatesterqa.dto.TestCaseRequestDto;
import org.example.jpatesterqa.dto.TestCaseResponseDto;
import org.example.jpatesterqa.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(@Autowired ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> getTestCases(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCase(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TestCaseResponseDto> createTestCase(@RequestBody @Valid TestCaseRequestDto testCase) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCase), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDto>> getAllTestCases(
            @JsonFormat(pattern = "dd-MM-yyyy")
            @JsonSerialize(using = LocalDateSerializer.class)
            @JsonDeserialize(using = LocalDateDeserializer.class)
            @RequestParam(name = "last_update", defaultValue = "")
            LocalDate lastUpdate) {
        return new ResponseEntity<>(testCaseService.getAllTestCases(lastUpdate), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> updateTestCase(@PathVariable Long id,
                                                              @RequestBody @Valid TestCaseRequestDto testCase) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCase), HttpStatus.OK);
    }
}
