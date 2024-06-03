package com.example.demo.controller;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.model.TestCase;
import com.example.demo.service.ITestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api")
@RestController
//@RequiredArgsConstructor
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;


    @GetMapping("/testcases")
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases(
            @RequestParam(required = false) String last_update) {
        return new ResponseEntity<>(testCaseService.getAllTestCases(last_update), HttpStatus.OK);
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCaseDTO> getTestById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.findTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/testcases/{id}")
    public  ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.ACCEPTED);
    }

}
