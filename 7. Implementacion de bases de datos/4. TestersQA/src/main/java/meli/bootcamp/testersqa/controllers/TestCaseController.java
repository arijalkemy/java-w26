package meli.bootcamp.testersqa.controllers;

import meli.bootcamp.testersqa.DTOs.TestCaseRequestDTO;
import meli.bootcamp.testersqa.services.interfaces.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(
            @RequestBody TestCaseRequestDTO testCaseRequestDTO
    ) {
        return new ResponseEntity<>(
                testCaseService.create(testCaseRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(
                testCaseService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
                testCaseService.findById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return new ResponseEntity<>(
                testCaseService.update(
                        id,
                        testCaseRequestDTO
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        testCaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/updated-after")
    public ResponseEntity<?> findTestCasesUpdatedAfter(
            @RequestParam(required = true, name = "last_update")
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate
    ) {
        return new ResponseEntity<>(
                testCaseService.findTestCasesUpdatedAfter(lastUpdate),
                HttpStatus.OK
        );
    }

}
