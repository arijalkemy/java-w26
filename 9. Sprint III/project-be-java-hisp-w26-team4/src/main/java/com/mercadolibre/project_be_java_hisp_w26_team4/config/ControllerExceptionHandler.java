package com.mercadolibre.project_be_java_hisp_w26_team4.config;

import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.*;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ExceptionDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.ApiError;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.ApiException;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.ProductNotFoundException;
import com.newrelic.api.agent.NewRelic;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

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

  @ExceptionHandler(InvalidCategoryException.class)
  public ResponseEntity<ApiError> HandleFoundExpection(InvalidCategoryException ex){
    ApiError apiError = new ApiError(
            "List_empty",
            ex.getMessage(),
            HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(UserIdNotFoundException.class)
  public ResponseEntity<ApiError> HandleFoundExpection(UserIdNotFoundException ex){
    ApiError apiError = new ApiError(
            "User_not_found",
            ex.getMessage(),
            HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
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
   * Handler for not found products.
   *
   * @param ex the exception thrown when product is not found.
   * @return {@link ResponseEntity} with 404 status code and the message
   *         not found in the body.
   */
  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<?> productNotFoundException(Exception ex) {
    ExceptionDTO exceptionDTO = ExceptionDTO.builder()
            .message(ex.getMessage())
            .status(HttpStatus.NOT_FOUND.toString())
            .build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ApiError> handlerValidConstraintViolationException(ConstraintViolationException ex){
    List<String> errors = ex.getConstraintViolations().stream()
            .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
            .toList();
    ApiError apiError = new ApiError("Error de validacion",
            errors,
            HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> NotFoundExceptionHandler(NotFoundException ex) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
  }

  @ExceptionHandler(NotAuthorizedException.class)
  public ResponseEntity<?> NotAuthorizedExceptionHandler(NotAuthorizedException ex) {
    return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(ex.getMessage());
  }

  @ExceptionHandler(InsufficientStockException.class)
  public ResponseEntity<?> InsufficientStockExceptionhandleException(InsufficientStockException ex) {
    return ResponseEntity
            .status(HttpStatus.CONFLICT) // Utilizamos HttpStatus.CONFLICT para indicar un conflicto
            .body(ex.getMessage());
  }

  @ExceptionHandler(AlreadyExistException.class)
  public ResponseEntity<?> AlreadyExistExceptionHandleException(AlreadyExistException ex) {
    return ResponseEntity
            .status(HttpStatus.CONFLICT) // Utilizamos HttpStatus.CONFLICT para indicar un conflicto
            .body(ex.getMessage());
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<?> BadRequestExceptionHandleException(BadRequestException ex) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST) // Utilizamos HttpStatus.CONFLICT para indicar un conflicto
            .body(ex.getMessage());
  }


}
