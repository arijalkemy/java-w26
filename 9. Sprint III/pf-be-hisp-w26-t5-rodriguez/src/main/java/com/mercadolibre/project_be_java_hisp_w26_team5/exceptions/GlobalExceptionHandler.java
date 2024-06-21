package com.mercadolibre.project_be_java_hisp_w26_team5.exceptions;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.exception.ExceptionDetails;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.ApiError;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.ApiException;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.InvalidParameterException;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.UserRoleMismatchException;
import com.newrelic.api.agent.NewRelic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String ERROR = "Error: {}";


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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> customValidationException(MethodArgumentNotValidException e) {
        List<FieldError> errorFields = e.getFieldErrors();

        Map<String, String> formattedErrors = new HashMap<>();
        for (FieldError field : errorFields) {
            formattedErrors.put(field.getField(), field.getDefaultMessage());
        }
        LOGGER.error(ERROR, formattedErrors);
        return new ResponseEntity<>(formattedErrors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidParameterException.class,
                       ConstraintViolationException.class,
                       HandlerMethodValidationException.class})
    @ResponseBody
    protected ExceptionDetails badRequest(Exception exception,
                                          HttpServletRequest request) {
        LOGGER.error(ERROR, exception.getMessage());
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    protected ExceptionDetails notFoundException(Exception exception,
                                                 HttpServletRequest request) {
        LOGGER.error(ERROR, exception.getMessage());
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserRoleMismatchException.class})
    @ResponseBody
    protected ExceptionDetails userRoleMismatchException(Exception exception,
                                                 HttpServletRequest request) {
        LOGGER.error(ERROR, exception.getMessage());
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }



    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    protected ExceptionDetails genericException(Exception exception,
                                                HttpServletRequest request) {
        LOGGER.error(ERROR, exception.getMessage());
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }
}
