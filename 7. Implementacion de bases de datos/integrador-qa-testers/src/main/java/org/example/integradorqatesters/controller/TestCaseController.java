package org.example.integradorqatesters.controller;

import lombok.RequiredArgsConstructor;
import org.example.integradorqatesters.model.dto.TestCaseRequestDTO;
import org.example.integradorqatesters.model.dto.TestCaseUpdateDTO;
import org.example.integradorqatesters.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestCaseController {
    private final ITestCaseService testCaseService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllTestCases(){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getAllTestCase());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getTestCase(id));
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.createTestCase(testCaseRequestDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.deleteTestCase(id));
    }

    @PutMapping("/")
    @ResponseBody
    public ResponseEntity<?> updateTestCase(@RequestBody TestCaseUpdateDTO testCaseUpdateDTO){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.updateTestCase(testCaseUpdateDTO));
    }

    @GetMapping(params = "last_update")
    @ResponseBody
    public ResponseEntity<?> getAllTestCasesLastUpdate(
            @RequestParam("last_update")
            @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate date){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getAllTestCaseLastUpdate(date));
    }

    @GetMapping(params = "passed_tested")
    @ResponseBody
    public ResponseEntity<?> getAllTestCasesPassedOrTested(@RequestParam("passed_tested") String value){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getAllTestCasePassedOrTested(value));
    }
}
