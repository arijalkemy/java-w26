package bootcamp.spring.link_tracker.exceptions;

public class InvalidUrlFormatException extends RuntimeException {
    public InvalidUrlFormatException(String message){
        super(message);
    }
}
