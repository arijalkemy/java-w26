package org.example.calories.services.impl;

import org.example.calories.dto.FoodIngredientDto;
import org.example.calories.entities.Food;
import org.example.calories.entities.Ingredient;
import org.example.calories.repositories.FoodRepository;
import org.example.calories.services.IFood;
import org.example.calories.services.IIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodImpl implements IFood {

    private final FoodRepository foodRepository;
    private final IIngredient iIngredient;

    public FoodImpl(@Autowired FoodRepository foodRepository, @Autowired IIngredient iIngredient) {
        this.foodRepository = foodRepository;
        this.iIngredient = iIngredient;
    }

    private FoodIngredientDto convertFootToDto(Food food) {
        List<Ingredient> ingredientList = new ArrayList<>();
        for (String ingredientName : food.getIngredients()) {
            Ingredient current = this.iIngredient.findByName(ingredientName);
            if (current != null) {
                ingredientList.add(current);
            }
        }
        return new FoodIngredientDto(food.getName(), ingredientList);
    }

    @Override
    public FoodIngredientDto findByName(String name) {
        return this.foodRepository.getFoodList()
                .stream()
                .map(this::convertFootToDto)
                .filter(food -> food.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<FoodIngredientDto> foodIngredientDtoList(String... dish) {
        List<FoodIngredientDto> foodIngredientDtoList = new ArrayList<>();
        for (String foodName : dish) {
            FoodIngredientDto current = this.findByName(foodName);
            if (current != null) {
                foodIngredientDtoList.add(current);
            }
        }
        return foodIngredientDtoList;
    }

    @Override
    public List<Food> findAll() {
        return this.foodRepository.getFoodList();
    }
}
