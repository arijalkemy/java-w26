package com.spring.calorias.dto;

import lombok.Getter;

@Getter
public class IngredientResponseDTO {

    private String name;
    private Double calories;
    private Double weight;

    public IngredientResponseDTO(String name, Double calories, Double weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }
}
