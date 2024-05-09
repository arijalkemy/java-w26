package com.bootcamp.diploma.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationErrorsDTO implements Serializable {
    Map<String, String> validationErrors;
}
