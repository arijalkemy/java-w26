package com.w26.testcase.testcase.controller;

import org.springframework.web.bind.annotation.RestController;

import com.w26.testcase.testcase.dto.Response;
import com.w26.testcase.testcase.dto.Testcase.PatchTestcase;
import com.w26.testcase.testcase.dto.Testcase.PostTestcase;
import com.w26.testcase.testcase.dto.Testcase.UpdateTestcase;
import com.w26.testcase.testcase.service.ITestcaseService;

import jakarta.validation.Valid;

import javax.sound.midi.Patch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/test_case")
public class TestcaseController {
    
    @Autowired
    ITestcaseService testcaseService;

    //Nota: Podría refactorizarce el tipo de objecto para evitar ambiguedad
    
    @PostMapping("/new")
    public ResponseEntity<?> postTestcase(@Valid @RequestBody PostTestcase toCreate)
    {
        Long id = testcaseService.createTestcase(toCreate);

        Response res = Response.builder()
        .message("Test case created with id: " + id)
        .result(id)
        .build();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestcase(@PathVariable Long id)
    {
        Response res = Response.builder()
        .message("Succesfully")
        .result(testcaseService.getTestcase(id))
        .build();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    // To get All
    @GetMapping("/all/{number_page}")
    public ResponseEntity<?> getTestcases(@PathVariable(name = "number_page") Integer numberPage)
    {
        Response res = Response.builder()
        .message("Succesfully")
        .result(testcaseService.getAllTestcases(numberPage))
        .build();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestcase(@PathVariable Long id)
    {

        Response res = Response.builder()
        .message("Succesfully deleted.")
        .result(testcaseService.deleteTestCase(id))
        .build();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchTestcase(@PathVariable Long id, @Valid @RequestBody PatchTestcase entity)
    {
        Response res = Response.builder()
                        .message("The student with id " + id + " was succesfully updated.")
                        .result(testcaseService.patchTestCase(id, entity))
                        .build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @Valid @RequestBody UpdateTestcase entity) {
        Response res = Response.builder()
                        .message("The student with id " + id + " was succesfully updated.")
                        .result(testcaseService.updateTestCase(id, entity))
                        .build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }


}