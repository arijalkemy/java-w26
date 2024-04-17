package com.meli.calculadoraDeCalorias.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class DishResponseDTO implements Serializable {
    private Integer totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO ingredientWithMostCalories;

    public DishResponseDTO(Integer totalCalories, List<IngredientDTO> ingredients, IngredientDTO ingredientWithMostCalories) {
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
        this.ingredientWithMostCalories = ingredientWithMostCalories;
    }
}
