package com.EjercicioSpring.Ejercicio13_LinkTracker.exception;

import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(annotations = RestController.class)
public class LinkTrackerExceptionHandler {

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorDTO> handlerLinkException(LinkException ex, WebRequest webRequest) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), webRequest.getDescription(false));
        return ResponseEntity.status(ex.getStatus()).body(errorDTO);
    }

}
