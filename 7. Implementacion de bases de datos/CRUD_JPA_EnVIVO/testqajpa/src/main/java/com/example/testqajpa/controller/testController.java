package com.example.testqajpa.controller;

import com.example.testqajpa.dto.TestcaseDTO;
import com.example.testqajpa.service.ITestQaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class testController {

    @Autowired
    private ITestQaService testQaService;

    @PostMapping("/new")
    public ResponseEntity<String> createTestcase(@RequestBody TestcaseDTO testcase) {
        String response = testQaService.crearTestQa(testcase);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TestcaseDTO>> getAllTestcases() {
        List<TestcaseDTO> testcases = testQaService.buscarTodosLosTestQa();
        return ResponseEntity.ok(testcases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestcaseDTO> getTestcaseById(@PathVariable Long id) {
        TestcaseDTO testcase = testQaService.buscarTestQaPorId(id);
        if (testcase == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testcase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTestcase(@PathVariable Long id, @RequestBody TestcaseDTO testcase) {
        try {
            String response = testQaService.actualizarTestQa(id, testcase);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestcase(@PathVariable Long id) {
        try {
            String response = testQaService.eliminarTestQa(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestcaseDTO>> getTestcasesByLastUpdate(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        List<TestcaseDTO> testcases = testQaService.buscarConFiltro(lastUpdate);
        return ResponseEntity.ok(testcases);
    }
}

