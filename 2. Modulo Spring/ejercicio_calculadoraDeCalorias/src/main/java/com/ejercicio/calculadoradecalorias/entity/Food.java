package com.ejercicio.calculadoradecalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Food {
    private String name;
    private List<FoodIngredient> foodIngredients;

    public double getTotalWeight() {
        return foodIngredients
                .stream()
                .mapToDouble(foodIngredient -> foodIngredient.getWeight())
                .sum();
    }

    public int getTotalCalories() {
        return foodIngredients
                .stream()
                .mapToInt(FoodIngredient::getIngredientCalories)
                .sum();
    }
}
