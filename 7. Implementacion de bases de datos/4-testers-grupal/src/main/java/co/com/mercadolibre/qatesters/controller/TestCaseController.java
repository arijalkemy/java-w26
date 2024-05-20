package co.com.mercadolibre.qatesters.controller;

import co.com.mercadolibre.qatesters.dto.TestCaseDTO;
import co.com.mercadolibre.qatesters.service.ITestCaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.ok(testCaseService.create(testCaseDTO));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(testCaseService.findAll());
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllPageable(Pageable page) {
        return ResponseEntity.ok(testCaseService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TestCaseDTO testCaseDTO, @PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.update(testCaseDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.delete(id));
    }

    @GetMapping("/last_update")
    public ResponseEntity<?> findByLastUpdate(@RequestParam(value = "last_update") LocalDate lastUpdate) {
        return ResponseEntity.ok(testCaseService.findByLastUpdate(lastUpdate));
    }
}
