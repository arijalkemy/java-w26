package com.spring.calorias.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class DishResponseDTO {

    private String name;
    private Double totalCalories;
    private List<IngredientResponseDTO> ingredients;
    private IngredientResponseDTO maxIngredient;

    public DishResponseDTO(
            String name,
            Double calories,
            List<IngredientResponseDTO> ingredients,
            IngredientResponseDTO maxIngredient) {
        this.name = name;
        this.totalCalories = calories;
        this.ingredients = ingredients;
        this.maxIngredient = maxIngredient;
    }
}
