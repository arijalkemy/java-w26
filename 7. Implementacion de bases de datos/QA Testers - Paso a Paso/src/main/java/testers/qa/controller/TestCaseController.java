package testers.qa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testers.qa.dto.TestCaseRequestDto;
import testers.qa.service.ITestCaseService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    @PostMapping("/testcases/new")
    public ResponseEntity<?> newVehiculo(@RequestBody TestCaseRequestDto testCaseRequestDto) {
        return new ResponseEntity<>(testCaseService.saveTest(testCaseRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/testcases")
    public ResponseEntity<?> allTestCases() {
        return new ResponseEntity<>(testCaseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<?> getTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDto testCaseRequestDto) {
        return new ResponseEntity<>(testCaseService.updateTest(id, testCaseRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTest(id), HttpStatus.OK);
    }

    @GetMapping("/testcases?last_update={date}")
    public ResponseEntity<?> getTestCasesByDate(@PathVariable LocalDate date) {
        return new ResponseEntity<>(testCaseService.findByDate(date), HttpStatus.OK);
    }
}
