package org.meli.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data

public class CustomException {
    private LocalDate time;
    private String message;
    private String uri;

    public CustomException(String message, String uri) {
        this.time = LocalDate.now();
        this.message = message;
        this.uri = uri.replace("uri=", "");
    }
}