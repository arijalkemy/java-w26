package com.example.calculadora_calorias.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IngredientDto {
    private String name;
    private Integer calories;
    private Float weight;
}
