package com.example.qatester.controller;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.model.TestCase;
import com.example.qatester.service.ITestService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/testcases")
public class TestController {
    @Autowired
    ITestService testService;

    @PostMapping("/new")
    ResponseEntity<TestCaseDto> add(@RequestBody @Validated TestCaseDto test) {
        return new ResponseEntity<>(testService.addTestCase(test), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<TestCaseDto>> getAll() {
        return new ResponseEntity<>(testService.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<TestCaseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(testService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<TestCaseDto> update(@PathVariable Long id) {
        return new ResponseEntity<>(testService.updateTestCase(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(testService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping("/last_update")
    ResponseEntity<List<TestCaseDto>> getAllTestCases(@RequestParam LocalDate date) {
        return new ResponseEntity<>(testService.filterTestCase(date), HttpStatus.OK);
    }
}
