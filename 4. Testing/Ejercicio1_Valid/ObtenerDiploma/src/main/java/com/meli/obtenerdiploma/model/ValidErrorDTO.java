package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;

import java.time.LocalDate;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidErrorDTO {

    private LocalDate time;
    private String message;
    private Map<String, String> mistakes;
    private String uri;

    public ValidErrorDTO(String message, Map<String, String> mistakes, String uri) {
        this.message = message;
        this.mistakes = mistakes;
        this.uri = uri.replace("uri=", "");
        time = LocalDate.now();
    }
}
