package org.implementaciondb.ejercicio3_qatesters.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
public class ValidErrorDto {

    private LocalDate time;
    private String message;
    private Map<String, String> mistakes;
    private String uri;

    public ValidErrorDto(String message, Map<String, String> mistakes, String uri) {
        this.message = message;
        this.mistakes = mistakes;
        this.uri = uri.replace("uri=", "");
        time = LocalDate.now();
    }
}
