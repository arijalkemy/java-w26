package com.bootcamp.qatesters.controller;

import com.bootcamp.qatesters.models.TestCase;
import com.bootcamp.qatesters.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }


    @PostMapping("/new")
    public ResponseEntity<?> postTestCase(@RequestBody TestCase test){
        return new ResponseEntity<>(testCaseService.addTestCase(test), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTestCases(){
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putTestCase(@PathVariable Long id, @RequestBody TestCase test){
        return new ResponseEntity<>(testCaseService.modifyTestCaseById(id,test), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCaseById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getByLastUpdateAfter(@RequestParam LocalDate last_update){
        return new ResponseEntity<>(testCaseService.findTestCasesAfterLastUpdate(last_update), HttpStatus.OK);
    }

}
