package org.ejercicio.qatesters.controller;

import org.ejercicio.qatesters.dto.TestCaseDto;
import org.ejercicio.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @GetMapping()
    public ResponseEntity<List<TestCaseDto>> getTestCases(@RequestParam(required = false) LocalDate date) {
        return new ResponseEntity<>(testCaseService.getTestCases(date),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id),HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<?> getTestCaseById(@RequestBody TestCaseDto testCaseDto) {
        testCaseService.saveTestCase(testCaseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable("id") Long id, @RequestBody TestCaseDto testCaseDto)
    {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDto),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TestCaseDto> deleteTestCase(@PathVariable("id") Long id)
    {
        testCaseService.deleteTestCaseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
