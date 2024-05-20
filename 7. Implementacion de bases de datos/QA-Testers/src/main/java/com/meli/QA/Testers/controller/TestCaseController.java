package com.meli.QA.Testers.controller;

import com.meli.QA.Testers.dto.ResponseDto;
import com.meli.QA.Testers.dto.TestCaseDto;
import com.meli.QA.Testers.service.ITestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestCaseController {

    private final ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDto> createTestCase(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseDto>> getAll(){
        return ResponseEntity.ok(testCaseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto){
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCaseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteTestCase(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.deleteTestCase(id));
    }
}
