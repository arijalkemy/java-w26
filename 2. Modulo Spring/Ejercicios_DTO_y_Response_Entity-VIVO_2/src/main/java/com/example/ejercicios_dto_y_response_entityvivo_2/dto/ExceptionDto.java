package com.example.ejercicios_dto_y_response_entityvivo_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ExceptionDto {
    @JsonProperty("error_message")
    private String errorMesagge;

    @JsonProperty("status_code")
    private String statusCode;
}
