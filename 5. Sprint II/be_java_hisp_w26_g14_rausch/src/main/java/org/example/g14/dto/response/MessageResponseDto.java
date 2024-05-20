package org.example.g14.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;


/**
 * El campo {@code detail} es opcional y puede ser un objeto de cualquier tipo,
 * para ajustarse a la necesidad de cada caso de uso.
 */
@Data
@AllArgsConstructor
public class MessageResponseDto {

    private String message;

    @JsonInclude(NON_EMPTY)
    private Object detail;


    public MessageResponseDto(String message) {
        this.message = message;
    }
}
