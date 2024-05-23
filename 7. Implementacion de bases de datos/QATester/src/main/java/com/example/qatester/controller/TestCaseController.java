package com.example.qatester.controller;

import com.example.qatester.dto.ResponseDTO;
import com.example.qatester.dto.TestCaseDTO;
import com.example.qatester.service.ITestCaseService;
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
    public ResponseEntity<ResponseDTO> postCreateTestCase(@RequestBody TestCaseDTO testCase){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.createTestCase(testCase));
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases(){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getTestCase(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> putUpdateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCase){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.updateTestCase(id, testCase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTestCase(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.deleteTestCase(id));
    }

}
