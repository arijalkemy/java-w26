package bootcamp.bendezujonathan.testcases.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import bootcamp.bendezujonathan.testcases.dto.response.MessageResponse;

@RestControllerAdvice
public class ExceptionRestHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponse> notFound(NotFoundException ex) {
        MessageResponse res = new MessageResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(res);
    }

}
