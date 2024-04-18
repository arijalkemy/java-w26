package com.ejercicio.calculadoradecalorias.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class FoodIngredient {
    private double weight;
    private Ingredient ingredient;
    private int ingredientCalories;

    public FoodIngredient(double weight, Ingredient ingredient) {
        this.weight = weight;
        this.ingredient = ingredient;
        this.ingredientCalories = getIngredientCalories();
    }

    public int getProportionalWeight(double foodWeight, double newWeight) {
        return (int)((newWeight/foodWeight) * weight);
    }

    public int getIngredientCalories() {
        return (int)((weight * ingredient.getCalories())/100);
    }
}
