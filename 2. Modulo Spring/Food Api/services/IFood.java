package org.example.calories.services;

import org.example.calories.dto.FoodIngredientDto;
import org.example.calories.entities.Food;

import java.util.List;

public interface IFood {
    FoodIngredientDto findByName(String name);

    List<Food> findAll();

    List<FoodIngredientDto> foodIngredientDtoList(String[] dish);
}
