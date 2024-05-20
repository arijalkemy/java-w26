package com.example.manualtester.controller;

import com.example.manualtester.dtos.TestCaseRequestDto;
import com.example.manualtester.model.TestCaseDTO;
import com.example.manualtester.service.ITestCaseService;
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
    ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public ResponseEntity createTestCase(@RequestBody TestCaseDTO testCaseDTO){
        iTestCaseService.createTest(testCaseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllTestCases(@RequestParam(required = false) LocalDate last_update){
        List<TestCaseDTO> testCasesDto = iTestCaseService.getAllTests(last_update);
        return new ResponseEntity<>(testCasesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneTestCase(@PathVariable Long id){
        TestCaseDTO testCaseDto = iTestCaseService.getOneTest(id);
        return new ResponseEntity<>(testCaseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity getOneTestCase(@RequestBody TestCaseDTO testCaseDTO){
        iTestCaseService.updateTest(testCaseDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTestCase(@PathVariable Long id){
        iTestCaseService.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
