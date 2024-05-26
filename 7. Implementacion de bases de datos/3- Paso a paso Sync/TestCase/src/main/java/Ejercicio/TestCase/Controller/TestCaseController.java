package Ejercicio.TestCase.Controller;

import Ejercicio.TestCase.Service.TestCaseServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCaseController {
    private final TestCaseServiceImpl testCaseService;

    public TestCaseController(TestCaseServiceImpl testCaseService) {
        this.testCaseService =  testCaseService;
    }
}
