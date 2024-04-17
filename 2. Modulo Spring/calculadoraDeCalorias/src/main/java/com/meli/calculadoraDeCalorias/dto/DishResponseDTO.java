package com.meli.calculadoraDeCalorias.dto;

import com.meli.calculadoraDeCalorias.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DishResponseDTO {
    private double totalCalories;
    private List<Ingredient> ingredients;
    private Ingredient mostCaloricIngredient;

    public DishResponseDTO(double totalCalories, List<Ingredient> ingredients, Ingredient mostCaloricIngredient) {
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
        this.mostCaloricIngredient = mostCaloricIngredient;
    }
}
