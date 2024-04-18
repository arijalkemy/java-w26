package bootcamp.spring.blog.exceptions;

public class AlreadyExistsException extends RuntimeException{
    
    public AlreadyExistsException(String mensaje){
        super(mensaje);
    }
}
