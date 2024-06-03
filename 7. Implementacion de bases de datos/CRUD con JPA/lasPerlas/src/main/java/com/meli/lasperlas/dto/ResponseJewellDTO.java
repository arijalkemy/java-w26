package com.meli.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseJewellDTO {
    @JsonProperty("nro_identificatorio")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("material")
    private String material;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("particularity")
    private String particularity;
    @JsonProperty("has_Stone")
    private Boolean has_stone;
    @JsonProperty("for_sale")
    private Boolean for_sale;
}
