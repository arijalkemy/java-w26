package org.ggomezr.calculadoradecalorias.application.service.impl;

import org.ggomezr.calculadoradecalorias.application.service.interfaces.IFoodService;
import org.ggomezr.calculadoradecalorias.domain.dto.DishDTO;
import org.ggomezr.calculadoradecalorias.domain.entity.Dish;
import org.ggomezr.calculadoradecalorias.domain.entity.Food;
import org.ggomezr.calculadoradecalorias.domain.repository.impl.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service

public class FoodService implements IFoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getAllIngredients() throws IOException {
        return foodRepository.getAllIngredients();
    }

    @Override
    public int getDishTotalCalories(Dish dish, int grams){
        List<Food> ingredients = dish.getIngredients();
        return ingredients.stream()
                .mapToInt(ingredient -> {
                    int caloriesPer100Grams = ingredient.getCalories();
                    return (caloriesPer100Grams * grams) / 100;
                })
                .sum();
    }

    @Override
    public Food getDishHigherCaloriesIngredient(Dish dish){
        List<Food> ingredients = dish.getIngredients();
        return ingredients.stream().max(Comparator.comparing(Food::getCalories)).get();
    }
}
