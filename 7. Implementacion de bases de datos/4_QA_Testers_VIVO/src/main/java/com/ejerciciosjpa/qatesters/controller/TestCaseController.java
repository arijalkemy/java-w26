package com.ejerciciosjpa.qatesters.controller;

import com.ejerciciosjpa.qatesters.dto.RequestTestCaseDto;
import com.ejerciciosjpa.qatesters.dto.ResponseTestCaseDto;
import com.ejerciciosjpa.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public void addTest(@RequestBody RequestTestCaseDto request){
        testCaseService.addTestCase(request);
    }
    @GetMapping("/api/testcases/all")
    public List<ResponseTestCaseDto> getAllTests(){
        return testCaseService.getAll();
    }
    @GetMapping("/api/testcases/{id}")
    public ResponseTestCaseDto getTestCaseById(@PathVariable Long id){
        return testCaseService.getTestCaseById(id);
    }
    @PutMapping("/api/testcases/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestTestCaseDto request){
        testCaseService.updateTestCase(id,request);
    }
    @DeleteMapping("/api/testcases/{id}")
    public void deleteTest(@PathVariable Long id){
        testCaseService.deleteTestCase(id);
    }
    @GetMapping("/api/testcases")
    public List<ResponseTestCaseDto> findTestAfterDate(@RequestParam LocalDate last_update){
        return testCaseService.findTestCaseByDate(last_update);
    }

}
