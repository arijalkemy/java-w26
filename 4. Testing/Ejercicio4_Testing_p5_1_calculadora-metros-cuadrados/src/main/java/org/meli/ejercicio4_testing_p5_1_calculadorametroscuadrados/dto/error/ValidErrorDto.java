package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;


@Data
public class ValidErrorDto {
    private String message;
    private Map<String, String> errors;

    public ValidErrorDto(String validationFailed, Map<String, String> errors) {
        this.message = validationFailed;
        this.errors = errors;
    }
}

