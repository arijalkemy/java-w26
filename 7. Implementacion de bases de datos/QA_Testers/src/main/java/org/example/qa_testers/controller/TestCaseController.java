package org.example.qa_testers.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.qa_testers.DTO.TestCaseRequestDTO;
import org.example.qa_testers.services.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;


    @PostMapping("/new")
    ResponseEntity<?> postNewTestCase(@RequestBody TestCaseRequestDTO testCase){
        return ResponseEntity.ok(testCaseService.createNewTestCase(testCase));
    }

    @GetMapping
    ResponseEntity<?> getAllTestCases(){
        return new ResponseEntity<>(testCaseService.findAllTestCases(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.findTestCaseById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    ResponseEntity<?> putTestCaseById(@PathVariable Long id,
                                      @RequestBody TestCaseRequestDTO testCase){
        return new ResponseEntity<>(testCaseService.updateTestCase(id,testCase), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTestCaseById(@PathVariable Long id){
        testCaseService.deleteById(id);
        return new ResponseEntity<>("The test case was eliminated",HttpStatus.OK);
    }

    @GetMapping(params = "last_update")
    ResponseEntity<?> getAllTestCaseAfterDate(@RequestParam
                                              @DateTimeFormat(pattern = "dd/MM/yyyy")
                                              LocalDate last_update){
        return new ResponseEntity<>(testCaseService.findAllTestAfterDate(last_update),HttpStatus.OK);
    }

}
