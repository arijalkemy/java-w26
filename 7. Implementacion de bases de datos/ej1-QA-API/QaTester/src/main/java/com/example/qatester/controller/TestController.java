package com.example.qatester.controller;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.time.LocalDate;

@Controller
@RequestMapping("/api/testcases")
public class TestController {
    @Autowired
    ITestService testService;

    @PostMapping("/new")
    ResponseEntity<?> add(@RequestBody @Validated TestCaseDto test) {
        return new ResponseEntity<>(testService.addTestCase(test), HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<?> getAllTestCases() {
        return new ResponseEntity<>(testService.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody @Validated TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testService.updateTestCase(id, testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping("/filter")
    ResponseEntity<?> filterTestCase(@RequestParam("last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        return new ResponseEntity<>(testService.filterTestCase(lastUpdate), HttpStatus.OK);
    }
}
