package com.meli.obtenerdiploma.model;

import lombok.Data;

@Data
public class ErrorDto {
    private String fieldName;
    private String message;
}
