package com.example.ejerciciocrudconjpavivo.controller;

import com.example.ejerciciocrudconjpavivo.dto.request.CreateTestCaseRequestDto;
import com.example.ejerciciocrudconjpavivo.dto.request.UpdateTestCaseRequestDto;
import com.example.ejerciciocrudconjpavivo.dto.response.ResponseMessageDto;
import com.example.ejerciciocrudconjpavivo.dto.response.TestCaseResponseDto;
import com.example.ejerciciocrudconjpavivo.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<ResponseMessageDto> createTestCase(
        @RequestBody CreateTestCaseRequestDto createTestCaseRequestDto
    ) {
        testCaseService.createTestCase(createTestCaseRequestDto);
        return new ResponseEntity<>(
            ResponseMessageDto.builder().message("Test case created successfully.").build(),
            HttpStatus.OK
        );
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseResponseDto>> getAllTestCases(
        @RequestParam(name = "last_update", required = false) String lastUpdate
    ) {
        return new ResponseEntity<>(
            testCaseService.searchAllTestCases(lastUpdate),
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> getTestCase(
        @PathVariable Long id
    ) {
        return new ResponseEntity<>(
            testCaseService.searchTestCaseById(id),
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> deleteTestCase(
        @PathVariable Long id
    ) {
        testCaseService.deleteTestCaseById(id);
        return new ResponseEntity<>(
            ResponseMessageDto.builder().message("Test case deleted successfully.").build(),
            HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> updateTestCase(
        @PathVariable Long id,
        @RequestBody UpdateTestCaseRequestDto updateTestCaseRequestDto
    ) {
        testCaseService.updateTestCase(id, updateTestCaseRequestDto);
        return new ResponseEntity<>(
            ResponseMessageDto.builder().message("Test case updated successfully.").build(),
            HttpStatus.OK
        );
    }
}
