package bootcamp.bendezujonathan.cloth.exception;

import bootcamp.bendezujonathan.cloth.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponse> notFound(NotFoundException ex) {
        return ResponseEntity.ok(new MessageResponse(ex.getMessage()));
    }
}
