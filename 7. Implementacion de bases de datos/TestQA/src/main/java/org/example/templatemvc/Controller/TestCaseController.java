package org.example.templatemvc.Controller;

import lombok.RequiredArgsConstructor;
import org.example.templatemvc.DTOs.Request.TestCaseRequest;
import org.example.templatemvc.DTOs.Response.TestCaseResponse;
import org.example.templatemvc.Service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/testcase")
public class TestCaseController {

    private final ITestCaseService service;

    @GetMapping("/list")
    public ResponseEntity<List<TestCaseResponse>> searchAll() {
        List<TestCaseResponse> response = service.getAllTestCases();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponse> searchById(@PathVariable("id") Long id) {
        TestCaseResponse response = service.getTestCaseById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<TestCaseResponse> create(@RequestBody TestCaseRequest request) {
        TestCaseResponse response = service.createTestCase(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TestCaseResponse> update(@PathVariable("id") Long id,
                                                   @RequestBody TestCaseRequest request) {
        TestCaseResponse response = service.updateTestCase(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deleteTestCase(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
