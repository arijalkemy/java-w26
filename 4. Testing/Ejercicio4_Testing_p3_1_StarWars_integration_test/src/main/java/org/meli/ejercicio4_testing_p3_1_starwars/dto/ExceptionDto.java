package org.meli.ejercicio4_testing_p3_1_starwars.dto;

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
