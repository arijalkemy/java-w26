package org.example.qttesters.controller;

import jakarta.validation.Valid;
import org.example.qttesters.dto.RequestTestCaseDto;
import org.example.qttesters.dto.ResponseTestCaseDto;
import org.example.qttesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<String> addTestCase(@RequestBody @Valid RequestTestCaseDto dto) {
        return new ResponseEntity<>(testCaseService.addTestCase(dto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<ResponseTestCaseDto>> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTestCaseDto> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable Long id, @RequestBody RequestTestCaseDto dto) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ResponseTestCaseDto>> findTestCaseByDate(@RequestParam String last_update) {
        return new ResponseEntity<>(testCaseService.findTestCaseByDate(last_update), HttpStatus.OK);
    }
}
