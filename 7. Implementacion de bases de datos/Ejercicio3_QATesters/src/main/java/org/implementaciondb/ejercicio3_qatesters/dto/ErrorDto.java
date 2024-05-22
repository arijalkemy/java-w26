package org.implementaciondb.ejercicio3_qatesters.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorDto {
    private LocalDate time;
    private String message;
    private String uri;

    public ErrorDto(String message, String uri) {
        this.time = LocalDate.now();
        this.message = message;
        this.uri = uri.replace("uri=", "");
    }
}
