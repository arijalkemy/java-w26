package com.spring.concesionaria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String title;
    private int statusCode;
    private String description;
}
