package com.meli.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateJewellDTO {
    @JsonProperty("nro_identificatorio")
    private Long id;
    private String name;
    private String material;
    private int weight;
    private String particularity;
    private Boolean has_stone;
    private Boolean for_sale;
}
