package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaExceptionControllerTest {
    @InjectMocks
    ObtenerDiplomaExceptionController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerDiplomaException() {
        ObtenerDiplomaException exception = new ObtenerDiplomaException("Error", HttpStatus.BAD_REQUEST);
        ResponseEntity<ErrorDTO> response = controller.handleGlobalExceptions(exception);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("ObtenerDiplomaException", response.getBody().getName());
        assertEquals("Error", response.getBody().getDescription());
    }

    @Test
    void testMethodArgumentNotValidException(){
        StudentDTO studentDTO = new StudentDTO();
        BindingResult bindingResult = new BeanPropertyBindingResult(studentDTO, "StudentDTO");
        bindingResult.rejectValue("studentName", "@Pattern", "El nombre del estudiante debe comenzar con mayúscula.");
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);

        ResponseEntity<ErrorDTO> response = controller.handleValidationExceptions(exception);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("MethodArgumentNotValidException", response.getBody().getName());
        assertEquals("El nombre del estudiante debe comenzar con mayúscula.", response.getBody().getDescription());
    }

    @Test
    void testHttpMessageNotReadableException() {
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("Error");
        ResponseEntity<ErrorDTO> response = controller.handleValidationExceptions(exception);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("HttpMessageNotReadableException", response.getBody().getName());
        assertEquals("Error", response.getBody().getDescription());
    }
}
