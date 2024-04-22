package bootcamp.linktracker.exceptions;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(String message){
        super(message);
    }
}
