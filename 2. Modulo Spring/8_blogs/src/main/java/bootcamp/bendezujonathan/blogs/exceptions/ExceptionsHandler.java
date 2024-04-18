package bootcamp.bendezujonathan.blogs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BlogNoCreatedException.class)
    public ResponseEntity<ErrorResponse> handleBlogNoCreatedEx(BlogNoCreatedException ex) {
        return this.createResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBlogNoCreatedEx(NotFoundException ex) {
        return this.createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<ErrorResponse> createResponse(String message, HttpStatus code) {
        return ResponseEntity.status(code)
                .body(new ErrorResponse(code.value(), message));
    }

    @Getter
    @RequiredArgsConstructor
    static class ErrorResponse {
        private final int code;
        private final String message;
    }
}
