package com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExceptionDto {
    private LocalDate time;
    private String message;
    private String uri;

    public ExceptionDto(String message, String uri) {
        this.time = LocalDate.now();
        this.message = message;
        this.uri = uri.replace("uri=", "");
    }
}
