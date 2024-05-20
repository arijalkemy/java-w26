package org.example.qatesters.controller;


import org.example.qatesters.DTO.RequestQATesterDTO;
import org.example.qatesters.service.IQATestersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class QATestersController {

    @Autowired
    private IQATestersService qATestersService;

    @PostMapping("/new")
    public ResponseEntity<RequestQATesterDTO> createTestCase(@RequestBody RequestQATesterDTO requestQATesterDTO) {
        return new ResponseEntity<>(qATestersService.createQATester(requestQATesterDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<RequestQATesterDTO>> getAllTestCases() {
        return new ResponseEntity<>(qATestersService.getAllQATesters(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestQATesterDTO> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(qATestersService.getQATesterById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestQATesterDTO> updateTestCase(@PathVariable Long id, @RequestBody RequestQATesterDTO requestQATesterDTO) {
        return new ResponseEntity<>(qATestersService.updateQATester(id, requestQATesterDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        qATestersService.deleteQATester(id);
        return new ResponseEntity<>("eliminado correctamente", HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<RequestQATesterDTO>> getTestCasesByStatus(@RequestParam("last_updated") LocalDate lastUpdated) {
        return new ResponseEntity<>(qATestersService.getTestCasesByStatus(lastUpdated), HttpStatus.OK);
    }
}
