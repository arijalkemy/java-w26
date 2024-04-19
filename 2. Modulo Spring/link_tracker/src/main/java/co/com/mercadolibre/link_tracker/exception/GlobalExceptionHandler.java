package co.com.mercadolibre.link_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException ex) {
        return getMapResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Map<String, Object>> getMapResponseEntity(RuntimeException ex, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("message", status.getReasonPhrase());
        response.put("timestamp", LocalDateTime.now());
        response.put("error", ex.getMessage());
        response.put("exception", ex.getClass().getSimpleName());
        return ResponseEntity.status(status).body(response);
    }
}
