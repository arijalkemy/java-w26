package meli.bootcamp.linktracker.exception;

public class InactiveLinkException extends RuntimeException {
    public InactiveLinkException(String message) {
        super(message);
    }
}
