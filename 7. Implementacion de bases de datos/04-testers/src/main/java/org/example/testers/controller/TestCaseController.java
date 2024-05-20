package org.example.testers.controller;

import org.example.testers.dto.TestCaseDTOReq;
import org.example.testers.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService service;

    @PostMapping("/new")
    ResponseEntity<?> create(@RequestBody TestCaseDTOReq testDTO) {
        return ResponseEntity.ok(service.create(testDTO));
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody TestCaseDTOReq testDTO) {
        return ResponseEntity.ok(service.update(id, testDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/last_update")
    ResponseEntity<?> filterByDate(@RequestParam String last_update){
        return ResponseEntity.ok(service.filterByDate(last_update));
    }
}
