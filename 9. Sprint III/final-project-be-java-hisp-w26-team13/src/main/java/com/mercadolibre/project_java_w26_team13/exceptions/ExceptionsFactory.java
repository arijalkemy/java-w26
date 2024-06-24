package com.mercadolibre.project_java_w26_team13.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionsFactory {

    public static ApiException notFoundException(String message) {
        return new ApiException(
                HttpStatus.NOT_FOUND.name(),
                message,
                HttpStatus.NOT_FOUND.value());
    }

    public static ApiException invalidOrderParameter(String message) {
        return new ApiException(
                HttpStatus.BAD_REQUEST.name(),
                message,
                HttpStatus.BAD_REQUEST.value());
    }

    public static ApiException badRequestException(String message) {
        return new ApiException(
                HttpStatus.BAD_REQUEST.name(),
                message,
                HttpStatus.BAD_REQUEST.value());
    }

    public static ApiException unauthorizedException(String message) {
        return new ApiException(
                HttpStatus.UNAUTHORIZED.name(),
                message,
                HttpStatus.UNAUTHORIZED.value());
    }
}
