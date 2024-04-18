package meli.bootcamp.calculadora.dto.mapper;

import meli.bootcamp.calculadora.dto.FoodDto;
import meli.bootcamp.calculadora.entity.Food;
import meli.bootcamp.calculadora.entity.Ingredient;

import java.util.Comparator;

public class Mapper {
    public static FoodDto toFoodDto(Food food) {
        return FoodDto.builder()
                .name(food.getName())
                .calories(food.getIngredients().stream().mapToInt(Ingredient::getCalories).sum())
                .ingredients(food.getIngredients())
                .maxCaloriesIngredient(food.getIngredients()
                        .stream()
                        .max(Comparator.comparingInt(Ingredient::getCalories))
                        .orElse(null))
                .build();
    }
}
