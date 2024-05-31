package com.example.dto_y_response_entityp2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SymptomsDto {
    @JsonProperty("codigo")
    private Long code;
    @JsonProperty("nombre")
    private String name;
    @JsonProperty("nivel_de_gravedad")
    private Long RiskLevel;
}
