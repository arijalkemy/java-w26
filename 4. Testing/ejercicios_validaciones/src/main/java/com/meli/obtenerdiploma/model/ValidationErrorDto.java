package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationErrorDto {
    private String fieldName;
    private String message;
}
