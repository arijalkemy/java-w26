package bootcamp.sprint.grupo02.sprintI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponseDTO> notFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageResponseDTO> notFound(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(UnfollowNotAllowedException.class)
    public ResponseEntity<String> badRequest(UnfollowNotAllowedException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
