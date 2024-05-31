package com.example.ejercicios_dto_y_response_entityvivo_2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SportDTO {
    @JsonProperty("nombre")
    private String name;
    @JsonProperty("nivel")
    private Long level;
}
