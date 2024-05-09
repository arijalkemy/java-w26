package org.example.be_java_hisp_w26_g04.service.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.be_java_hisp_w26_g04.dto.ValidationErrorsResponseDTO;
import org.example.be_java_hisp_w26_g04.exceptions.GlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GlobalExceptionHandlerTest {
    private GlobalExceptionHandler handler;
    private MethodArgumentNotValidException ex;

    @BeforeEach
    public void setup() {
        handler = new GlobalExceptionHandler();
        ex = mock(MethodArgumentNotValidException.class);
    }

    @Test
    @DisplayName("Handle validation exceptions returns correct response")
    public void handleValidationExceptionsReturnsCorrectResponse() {
        // Arrange
        BindingResult bindingResult = mock(BindingResult.class);
        List<FieldError> fieldErrors = List.of(
            new FieldError("object", "field", "defaultMessage")
        );

        when(ex.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);

        // Act
        ResponseEntity<ValidationErrorsResponseDTO> response = handler.handleValidationExceptions(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Hay errores de validación", response.getBody().getMessage());
        assertEquals(Map.of("field", "defaultMessage"), response.getBody().getErrors());
    }

    @Test
    @DisplayName("Handle validation exceptions returns empty errors when no field errors")
    public void handleValidationExceptionsReturnsEmptyErrorsWhenNoFieldErrors() {
        // Arrange
        BindingResult bindingResult = mock(BindingResult.class);
        when(ex.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(List.of());

        // Act
        ResponseEntity<ValidationErrorsResponseDTO> response = handler.handleValidationExceptions(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Hay errores de validación", response.getBody().getMessage());
        assertEquals(new HashMap<>(), response.getBody().getErrors());
    }
}