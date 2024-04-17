package com.meli.calculadoraDeCalorias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {
    private String name;
    private double calories;

    public IngredientDTO(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }
}
