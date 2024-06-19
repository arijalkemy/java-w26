package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.config;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.ExceptionDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.exceptions.ApiError;
import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.exceptions.ApiException;
import com.newrelic.api.agent.NewRelic;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.stream.Collectors;

/**
 * Basic handling for exceptions.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

  /**
   * Handler for not found routes.
   *
   * @param ex the exception thrown when route is not found.
   * @return {@link ResponseEntity} with 404 status code and the route that was
   *         not found in the body.
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ApiError> noHandlerFoundException(NoHandlerFoundException ex) {
    ApiError apiError = new ApiError(
        "route_not_found",
        String.format("Route %s not found", ex.getRequestURL()),
        HttpStatus.NOT_FOUND.value());
    return ResponseEntity
        .status(apiError.getStatus())
        .body(apiError);
  }

  /**
   * Handler for external API exceptions.
   *
   * @param e the exception thrown during a request to external API.
   * @return {@link ResponseEntity} with status code and description provided for the handled exception.
   */
  @ExceptionHandler(ApiException.class)
  protected ResponseEntity<ApiError> handleApiException(ApiException e) {
    Integer statusCode = e.getStatusCode();
    boolean expected = HttpStatus.INTERNAL_SERVER_ERROR.value() > statusCode;
    NewRelic.noticeError(e, expected);
    if (expected) {
      LOGGER.warn("Internal Api warn. Status Code: " + statusCode, e);
    } else {
      LOGGER.error("Internal Api error. Status Code: " + statusCode, e);
    }

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), statusCode);
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  /**
   * Handler for internal exceptions.
   *
   * @param e the exception thrown during request processing.
   * @return {@link ResponseEntity} with 500 status code and description indicating an internal error.
   */
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handleUnknownException(Exception e) {
    LOGGER.error("Internal error", e);
    NewRelic.noticeError(e);

    ApiError apiError =
        new ApiError(
            "internal_error", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  /**
   * Maneja las excepciones de tipo MethodArgumentNotValidException.
   *
   * @param e La excepción lanzada.
   * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP BAD_REQUEST.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
    String errorMessage = e.getBindingResult().getFieldErrors().stream()
            .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
            .collect(Collectors.joining(", "));
    ExceptionDTO exceptionDto = new ExceptionDTO(errorMessage);
    return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
  }

  /**
   * Maneja las excepciones de tipo ConstraintViolationException.
   *
   * @param e La excepción lanzada.
   * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP BAD_REQUEST.
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException e) {
    String errorMessage = e.getConstraintViolations().stream()
            .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
            .collect(Collectors.joining(", "));
    ExceptionDTO exceptionDto = new ExceptionDTO(errorMessage);
    return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
  }

  /**
   * Maneja las excepciones de tipo HttpMessageNotReadableException.
   *
   * @param e La excepción lanzada.
   * @return Una respuesta HTTP con el mensaje de la excepción y el estado HTTP BAD_REQUEST.
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<?> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
    ExceptionDTO exceptionDto = new ExceptionDTO("Error al leer el cuerpo de la solicitud");
    return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
  }
}
