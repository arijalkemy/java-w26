package bootcamp.sprint.grupo02.sprintI.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ValidationResponseDTO;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationResponseDTO>> noValidArg(MethodArgumentNotValidException ex) {
        List<ValidationResponseDTO> errors = ex.getFieldErrors()
                .stream()
                .map(field -> ValidationResponseDTO.builder()
                        .rejectedValue(field.getRejectedValue())
                        .field(field.getField())
                        .message(field.getDefaultMessage())
                        .build())
                .toList();

        return ResponseEntity.badRequest()
                .body(errors);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<List<MessageResponseDTO>> noValidationException(HandlerMethodValidationException ex) {
        List<MessageResponseDTO> errors = ex.getAllErrors()
                .stream()
                .map(x -> new MessageResponseDTO(x.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errors);

    }
}
