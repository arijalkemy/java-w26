package bootcamp.bendezujonathan.perlas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import bootcamp.bendezujonathan.perlas.dto.response.MessageResponse;

@RestControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponse> handlerNotFound(NotFoundException ex) {
        MessageResponse response = new MessageResponse(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(response);
    }

}
