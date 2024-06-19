package com.mercadolibre.fresh_market.config;

import com.mercadolibre.fresh_market.dtos.ResponseDTO;
import com.mercadolibre.fresh_market.exceptions.*;
import com.newrelic.api.agent.NewRelic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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
     * not found in the body.
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

    @ExceptionHandler(NoRolePermitionsException.class)
    protected ResponseEntity<ApiError> handleNoRolePermitionsException(NoRolePermitionsException e) {
        LOGGER.error("No role permitions", e);
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        e.getMessage(), e.getMessage(), HttpStatus.FORBIDDEN.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(UserNotFoundException.class)
        protected ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException e) {
            LOGGER.error("User not found", e);
            NewRelic.noticeError(e);

            ApiError apiError =
                    new ApiError(
                            "User not exist", e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }


    @ExceptionHandler(NoStockAvavility.class)
    protected ResponseEntity<ApiError> handleNoStockAvavility(NoStockAvavility e) {
        LOGGER.error("No stock avavility", e);
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        "no_stock_avavility", "No stock avavility", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(StatusInvalidException.class)
    protected ResponseEntity<ApiError> handleStatusInvalidException(StatusInvalidException e) {
        LOGGER.error("Status invalid", e);
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        e.getMessage(), e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        LOGGER.error("Http message not readable", e);
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        "Error", e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

 @ExceptionHandler(ApiExceptionDetailed.class)
 public ResponseEntity<ApiErrorDetailed> handlerNotFountEntitiesException(ApiExceptionDetailed exception) {  
  return ResponseEntity.status(exception.getStatusCode()).body(
    ApiErrorDetailed.builder()
    .error(exception.getCode())
    .message(exception.getMessage())
    .detail(exception.getDetail())
        .build());
}
    @ExceptionHandler(ProductNotFoundException.class)
        protected ResponseEntity<ApiError> handleProductNotFoundException(ProductNotFoundException e) {
            LOGGER.error("Product not found", e);
            NewRelic.noticeError(e);

            ApiError apiError =
                    new ApiError(
                            "Product not exist", e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handlerAccesDeniedException(AccessDeniedException exception) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(exception.getMessage(), null));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handlerBadCredentialsException(BadCredentialsException exception) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(exception.getMessage(), null));
    }

    @ExceptionHandler(CategoryBadRequestException.class)
    protected ResponseEntity<ApiError> handleCategoryBadRequestException(CategoryBadRequestException e) {
        LOGGER.error("Category is not valid", e);
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        "This category is not valid: ", e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(ProductsNotFoundException.class)
    protected ResponseEntity<ApiError> handleProductsNotFoundException(ProductsNotFoundException e) {
        LOGGER.error("Products not found", e);
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        "Products not found: ", e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ApiError> handleBadRequestException(BadRequestException e) {
        LOGGER.error("Bad request: ", e);
        NewRelic.noticeError(e);

        ApiError apiError =
                new ApiError(
                        "Bad request: ", e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    protected ResponseEntity<ApiError> handleUnauthorizedAccessException(UnauthorizedAccessException e) {
        LOGGER.error("Unauthorized access", e);
        NewRelic.noticeError(e);

        ApiError apiError = new ApiError(
                "unauthorized_access", "You don't have permissions to access this resource", HttpStatus.FORBIDDEN.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(NumberFormatException.class)
    protected ResponseEntity<ApiError> handleNumberFormatException(NumberFormatException e) {
        LOGGER.error("Invalid parameter, must be numeric type.", e.getMessage());
        NewRelic.noticeError(e);

        ApiError apiError = new ApiError(
                "Invalid parameter", e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ApiError> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        LOGGER.error("Invalid parameter, must be numeric type.", e.getMessage());
        NewRelic.noticeError(e);

        ApiError apiError = new ApiError(
                "Invalid parameter", e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}



