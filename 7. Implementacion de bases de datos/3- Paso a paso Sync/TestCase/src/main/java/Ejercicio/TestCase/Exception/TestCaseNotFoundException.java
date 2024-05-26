package Ejercicio.TestCase.Exception;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(String message) {
        super(message);
    }
}
