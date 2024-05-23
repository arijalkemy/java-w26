package com.ejerciciocrud.qatester.controller;

import com.ejerciciocrud.qatester.dto.request.MessageDTO;
import com.ejerciciocrud.qatester.dto.request.TestCaseRequestDTO;
import com.ejerciciocrud.qatester.dto.response.TestCaseResponseDTO;
import com.ejerciciocrud.qatester.service.ITestCaseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    @GetMapping()
    public ResponseEntity<List<TestCaseResponseDTO>> getAllTests(){
        List<TestCaseResponseDTO> testCases = testCaseService.showAllTests();
        return ResponseEntity.ok().body(testCases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestsById(@PathVariable Long id){
        TestCaseResponseDTO testCase = testCaseService.showTestById(id);
        return ResponseEntity.ok().body(testCase);
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> addNewTest(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        MessageDTO messageDTO = testCaseService.addTestCase(testCaseRequestDTO);
        return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> updateTestById(@PathVariable Long id,
                                                              @RequestBody TestCaseRequestDTO testCaseRequestDTO){
        TestCaseResponseDTO testCase = testCaseService.updateTestById(id, testCaseRequestDTO);
        return ResponseEntity.ok().body(testCase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteTestById(@PathVariable Long id){
        MessageDTO messageDTO = testCaseService.removeTestCase(id);
        return ResponseEntity.ok().body(messageDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseResponseDTO>> getTestsAfterDate(@RequestParam ("last_update") LocalDate lastUpdate){
        List<TestCaseResponseDTO> testCases = testCaseService.showTestAfterDate(lastUpdate);
        return ResponseEntity.ok().body(testCases);
    }
}
