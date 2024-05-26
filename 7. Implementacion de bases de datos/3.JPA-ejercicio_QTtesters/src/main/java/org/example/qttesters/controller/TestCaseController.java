package org.example.qttesters.controller;

import org.example.qttesters.dto.RequestTestCaseDto;
import org.example.qttesters.dto.ResponseTestCaseDto;
import org.example.qttesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<RequestTestCaseDto> postTestCase(@RequestBody RequestTestCaseDto requestTestCaseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.addTestCase(requestTestCaseDto));
    }

    @GetMapping
    public ResponseEntity<List<ResponseTestCaseDto>> getAllTestCase(){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTestCaseDto> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.findTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTestCaseDto> putTestCase(@PathVariable Long id,  @RequestBody RequestTestCaseDto requestTestCaseDto){
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.updateTestCase(id, requestTestCaseDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> putTestCase(@PathVariable Long id){
        testCaseService.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = "last_update")
    public ResponseEntity<List<ResponseTestCaseDto>> getAllTestCaseByDate(@RequestParam LocalDate last_update){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.findTestCaseByDate(last_update));
    }
}
