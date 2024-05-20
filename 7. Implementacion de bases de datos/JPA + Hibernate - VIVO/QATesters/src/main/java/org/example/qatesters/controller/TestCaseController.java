package org.example.qatesters.controller;

import lombok.RequiredArgsConstructor;
import org.example.qatesters.dto.TestCaseRequestDTO;
import org.example.qatesters.dto.TestCaseResponseDTO;
import org.example.qatesters.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<String> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        Long recentlyCreatedId = testCaseService.create(testCaseRequestDTO);
        return new ResponseEntity<>(
                "Se test case con el ID = " + recentlyCreatedId,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDTO>> getAllTestCases() {
        return new ResponseEntity<>(
                testCaseService.listAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseWithId(@PathVariable Long id) {
        return new ResponseEntity<>(
                testCaseService.getById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<TestCaseResponseDTO> updateTestCaseWithId(
            @PathVariable Long id,
            @RequestBody TestCaseRequestDTO testCaseRequestDTO
    ) {
        return new ResponseEntity<>(
                testCaseService.updateById(id, testCaseRequestDTO),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDTO>> searchUpdatedAfterDate(@RequestParam LocalDate localDateFrom) {
        return new ResponseEntity<>();
    }
}
