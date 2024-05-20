package com.example.qatester.controller;

import com.example.qatester.dto.requestDto.TestCaseRequestDto;
import com.example.qatester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> addTestCase(@RequestBody TestCaseRequestDto testCaseRequestDto){
        return new ResponseEntity<>(iTestCaseService.addTestCase(testCaseRequestDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAllTestCases(){
        return new ResponseEntity<>(iTestCaseService.findAllTestCases(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTestCaseById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(iTestCaseService.findTestCaseById(id), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editTestCase(@PathVariable Long id,
                                          @RequestBody TestCaseRequestDto testCaseRequestDto) throws Exception {
        return new ResponseEntity<>(iTestCaseService.editTestCase(id, testCaseRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) throws Exception {
        iTestCaseService.deleteTestCase(id);
        return new ResponseEntity<>("Borrado exitoso", HttpStatus.OK);
    }

    @GetMapping("/afterDate")
    public ResponseEntity<?> findTestCaseAfterDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(iTestCaseService.findTestCasesAfterDate(date), HttpStatus.CREATED);
    }
}
