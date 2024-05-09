package com.meli.be_java_hisp_w26_g09.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.ExceptionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExceptionControllerTest {
    private final ExceptionController exceptionController = new ExceptionController();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;

    @Test
    @DisplayName("Test not found exception")
    void testNotFoundException() {
        NotFoundException notFoundException = new NotFoundException("Not Found Exception");

        ResponseEntity<?> responseEntity = exceptionController.notFoundException(notFoundException);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Not Found Exception", ((ExceptionDTO) responseEntity.getBody()).getMessage());
    }


    @Test
    @DisplayName("Test http message not readable exception")
    void testHttpMessageNotReadableException() {
        HttpMessageNotReadableException httpMessageNotReadableException = new HttpMessageNotReadableException("Invalid date format");

        ResponseEntity<ExceptionDTO> responseEntity = exceptionController.httpMessageNotReadableException(httpMessageNotReadableException);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("The format date is dd-MM-yyyy", responseEntity.getBody().getMessage());
    }

    @Test
    public void testNotContentFollowedException() {
        // Arrange
        NotContentFollowedException exception = new NotContentFollowedException("Not Content Followed Exception");

        // Act
        ResponseEntity<?> responseEntity = exceptionController.notContentFollowedException(exception);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ExceptionDTO);
        assertEquals("Not Content Followed Exception", ((ExceptionDTO) responseEntity.getBody()).getMessage());
    }

    @Test
    public void testNotSameTyping() {
        // Arrange
        MethodArgumentTypeMismatchException exception = new MethodArgumentTypeMismatchException(null, null, null, null, null);

        // Act
        ResponseEntity<?> responseEntity = exceptionController.notSameTyping(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ExceptionDTO);
        assertEquals("Not same typing attribute", ((ExceptionDTO) responseEntity.getBody()).getMessage());
    }

    @Test
    public void testBadRequestException() {
        // Arrange
        BadRequestException exception = new BadRequestException("Bad Request Exception");

        // Act
        ResponseEntity<?> responseEntity = exceptionController.badRequestException(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ExceptionDTO);
        assertEquals("Bad Request Exception", ((ExceptionDTO) responseEntity.getBody()).getMessage());
    }

    @Test
    public void testHandleBadValidation() {
        // Mocking field errors
        FieldError fieldError1 = mock(FieldError.class);
        when(fieldError1.getDefaultMessage()).thenReturn("Field 1 is required");
        when(fieldError1.getField()).thenReturn("field1");

        FieldError fieldError2 = mock(FieldError.class);
        when(fieldError2.getDefaultMessage()).thenReturn("Field 2 must be a positive number");
        when(fieldError2.getField()).thenReturn("field2");

        List<FieldError> fieldErrors = List.of(fieldError1, fieldError2);

        // Mocking MethodArgumentNotValidException
        methodArgumentNotValidException = mock(MethodArgumentNotValidException.class);
        when(methodArgumentNotValidException.getFieldErrors()).thenReturn(fieldErrors);

        // Calling the method under test
        ResponseEntity<List<ExceptionDTO>> responseEntity = exceptionController.handleBadValidation(methodArgumentNotValidException);

        // Asserting the response
        assertEquals(400, responseEntity.getStatusCodeValue()); // Expected HTTP status code: 400 (Bad Request)

        List<ExceptionDTO> exceptionDTOList = responseEntity.getBody();
        assertEquals(2, exceptionDTOList.size()); // Expecting 2 field errors

        // Asserting each field error
        ExceptionDTO exceptionDTO1 = exceptionDTOList.get(0);
        assertEquals("Field 1 is required", exceptionDTO1.getMessage());
        assertEquals("field1", exceptionDTO1.getField());

        ExceptionDTO exceptionDTO2 = exceptionDTOList.get(1);
        assertEquals("Field 2 must be a positive number", exceptionDTO2.getMessage());
        assertEquals("field2", exceptionDTO2.getField());
    }
}