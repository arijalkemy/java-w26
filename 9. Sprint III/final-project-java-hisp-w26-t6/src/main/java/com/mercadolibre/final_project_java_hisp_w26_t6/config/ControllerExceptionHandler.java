package com.mercadolibre.final_project_java_hisp_w26_t6.config;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ExceptionDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.*;
import com.newrelic.api.agent.NewRelic;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

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

  // ---------
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> notFound(NotFoundException e) {
    ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
    return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<?> badCredentials(BadCredentialsException e) {
    ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
    return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<?> accessDenied(AccessDeniedException e) {
    ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
    return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<?> badRequest(BadRequestException e) {
    ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
    return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<?> methodNotSupported(HttpRequestMethodNotSupportedException e) {
    ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
    return new ResponseEntity<>(exceptionDto, HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> controllerExceptionHandler(ConstraintViolationException e) {
    ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
    return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    return ResponseEntity.badRequest().body(new ExceptionDto(ex.getFieldErrors().get(0).getDefaultMessage()));
  }

  @ExceptionHandler(value = HttpMessageNotReadableException.class)
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
    return ResponseEntity.badRequest().body(new ExceptionDto(buildMessage(ex)));
  }

  private String buildMessage(Exception ex) {
    String[] splitted = ex.getMessage().split("default message");
    return "Campo: " + splitted[1].trim().substring(0, splitted[1].length() - 4) + " inválido, mensaje: " + splitted[2].trim().substring(0, splitted[2].length() - 3) + ".";
  }
}
