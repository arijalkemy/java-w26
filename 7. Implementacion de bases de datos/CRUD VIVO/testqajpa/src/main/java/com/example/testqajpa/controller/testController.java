package com.example.testqajpa.controller;

import com.example.testqajpa.dto.TestcaseDTO;
import com.example.testqajpa.service.ITestQaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/testcases")
public class testController {

    @Autowired
    ITestQaService testQaService;

    @PostMapping("/new")
    public ResponseEntity<?> createTestcase(@RequestBody TestcaseDTO testcaseDTO)
    {
        return ResponseEntity.ok().body(testQaService.crearTestQa(testcaseDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAllTestcases()
    {
        return ResponseEntity.ok().body(testQaService.buscarTodosLosTestQa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestcaseById(Long id)
    {
        return ResponseEntity.ok().body(testQaService.buscarTestQaPorId(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateTestcase(@PathVariable Long id, @RequestBody TestcaseDTO testcaseDTO)
    {
        return ResponseEntity.ok().body(testQaService.actualizarTestQa(id, testcaseDTO));
    }

    @DeleteMapping("{id}")
    public String deleteTestcase(@PathVariable Long id)
    {
        return testQaService.eliminarTestQa(id);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getTestcasesByDate(@RequestParam LocalDate lastupdate)
    {
        return ResponseEntity.ok().body(testQaService.buscarConFiltro(lastupdate));
    }

}
