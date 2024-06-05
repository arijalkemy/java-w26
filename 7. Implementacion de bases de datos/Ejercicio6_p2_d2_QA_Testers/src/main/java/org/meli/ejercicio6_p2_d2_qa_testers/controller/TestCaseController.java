package org.meli.ejercicio6_p2_d2_qa_testers.controller;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.Filter;
import org.meli.ejercicio6_p2_d2_qa_testers.dto.TestCaseDtoRequest;
import org.meli.ejercicio6_p2_d2_qa_testers.dto.TestCaseDtoResponse;
import org.meli.ejercicio6_p2_d2_qa_testers.service.ITestCaseService;
import org.meli.ejercicio6_p2_d2_qa_testers.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDtoResponse> saveTestCase(@RequestBody TestCaseDtoRequest test) {
        return new ResponseEntity<>(testCaseService.save(test), HttpStatus.OK);
    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCaseDtoResponse>> getAllTestCase() {
        return new ResponseEntity<>(testCaseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDtoResponse> getIdTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDtoResponse> putIdTestCase(@PathVariable Long id,
                                                             @RequestBody TestCaseDtoRequest test) {
        return new ResponseEntity<>(testCaseService.udpate(id, test), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIdTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCaseDtoResponse>> getAllTestCaseByFilter
            (@RequestParam(name = "filter") LocalDate filter) {
        return new ResponseEntity<>(testCaseService.getAllTestCaseByFilter(filter), HttpStatus.OK);
    }

}
