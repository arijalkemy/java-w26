package com.example.manualtester.controller;

import com.example.manualtester.model.TestCase;
import com.example.manualtester.model.TestCaseDTO;
import com.example.manualtester.model.TestCaseReponse;
import com.example.manualtester.model.TestToUpdateDTO;
import com.example.manualtester.service.ITestCaseService;
import lombok.Getter;
import org.hibernate.type.descriptor.java.LongJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestCaseController {

    @Autowired
    ITestCaseService iTestCaseService;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<?> createNewCase(@RequestBody TestCaseDTO dto) {
        iTestCaseService.createTest(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> getAllCases(){
        return new ResponseEntity<>(iTestCaseService.getAllTests(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseReponse> getCaseById(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.getOneTest(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/update")
    public ResponseEntity<?> updateATest(@RequestBody TestToUpdateDTO dtoRequest) {
        return new ResponseEntity<>(iTestCaseService.updateTest(dtoRequest), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable Long id){
        iTestCaseService.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
