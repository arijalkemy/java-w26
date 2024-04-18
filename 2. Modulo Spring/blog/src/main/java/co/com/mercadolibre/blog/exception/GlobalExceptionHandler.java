package co.com.mercadolibre.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BlogEntryAlreadyExistsException.class})
    public ResponseEntity<Map<String, Object>> handleBlogEntryAlreadyExistsException(BlogEntryAlreadyExistsException ex) {
        return getMapResponseEntity(ex.getMessage(), ex, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException ex) {
        return getMapResponseEntity(ex.getMessage(), ex, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Map<String, Object>> getMapResponseEntity(String message, RuntimeException ex, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("message", status.getReasonPhrase());
        response.put("timestamp", LocalDateTime.now());
        response.put("error", message);
        return ResponseEntity.status(status).body(response);
    }
}
