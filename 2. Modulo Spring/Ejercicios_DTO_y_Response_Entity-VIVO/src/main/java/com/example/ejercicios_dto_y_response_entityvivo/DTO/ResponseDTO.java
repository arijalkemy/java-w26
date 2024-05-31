package com.example.ejercicios_dto_y_response_entityvivo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ResponseDTO {
    @JsonProperty("years")
    private String message;
}
