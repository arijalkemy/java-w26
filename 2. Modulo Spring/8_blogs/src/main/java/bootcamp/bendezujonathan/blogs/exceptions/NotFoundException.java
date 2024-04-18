package bootcamp.bendezujonathan.blogs.exceptions;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message){
        super(message);
    }
}
