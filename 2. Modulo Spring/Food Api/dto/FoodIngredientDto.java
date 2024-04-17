package org.example.calories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.calories.entities.Ingredient;

import java.util.Comparator;
import java.util.List;

@Getter
@AllArgsConstructor
public class FoodIngredientDto {
    private String name;
    private List<Ingredient> ingredientList;

    public Integer getTotalCalories() {
        return ingredientList.stream().mapToInt(Ingredient::getCalories).sum() / 100;
    }

    public String getIngredientMaxCalories() {
        return ingredientList.stream().max(Comparator.comparing(Ingredient::getCalories)).get().getName();
    }
}
