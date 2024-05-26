package org.responseentity.qatesters.controller;

import jakarta.websocket.server.PathParam;
import org.responseentity.qatesters.dto.TestCaseDTO;
import org.responseentity.qatesters.service.TestCaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    TestCaseServiceImpl testCaseService;

    @GetMapping
    public ResponseEntity<?> listAllTheTestCase(){
        return new ResponseEntity<>(testCaseService.listAllTestCase(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable("id") Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable("id") Long id, @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>("Test Case eliminado", HttpStatus.OK);
    }

    @GetMapping("/last_update")
    public ResponseEntity<?> findTestCasesByDate(
            @PathParam("update")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate update){
        return new ResponseEntity<>(testCaseService.findByLastUpdate(update), HttpStatus.OK);
    }
}
