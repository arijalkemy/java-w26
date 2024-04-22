package meli.bootcamp.blog.exception;

public class DuplicateEntryException extends RuntimeException {
    public DuplicateEntryException(String message){
        super(message);
    }
}
