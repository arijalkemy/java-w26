package meli.bootcamp.testersqa.exceptions;

public class TestCaseNotFoundException extends RuntimeException{
    public TestCaseNotFoundException(String message) {
        super(message);
    }
}
