package com.meli.lasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestJewellDTO {
    private String name;
    private String material;
    private int weight;
    private String particularity;
    private Boolean has_stone;
    private Boolean for_sale;
}
