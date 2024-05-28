package com.mercadolibre.qatesters.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.qatesters.dto.TestCaseRequest;
import com.mercadolibre.qatesters.dto.TestCaseResponse;
import com.mercadolibre.qatesters.service.ITestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "testcases")
@RequiredArgsConstructor
public class TestCaseController {
    private final ITestCaseService testCaseService;

    @PostMapping("new")
    public ResponseEntity<Void> postNewTestCase(@RequestBody TestCaseRequest testCase) {
        testCaseService.create(testCase);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponse>> getAll(@RequestParam(name = "last_update")
                                                         @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                         Optional<LocalDate> lastUpdate) {
        return lastUpdate.map(date -> ResponseEntity.ok(testCaseService.getByDateHigherThan(date)))
                .orElseGet(() -> ResponseEntity.ok(testCaseService.getAll()));

    }

    @GetMapping("{id}")
    public ResponseEntity<TestCaseResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> putTestCase(@PathVariable Long id, @RequestBody TestCaseRequest testCase) {
        testCaseService.update(id, testCase);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        testCaseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
