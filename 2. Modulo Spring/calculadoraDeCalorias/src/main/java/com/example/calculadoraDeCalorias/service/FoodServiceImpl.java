package com.example.calculadoraDeCalorias.service;

import com.example.calculadoraDeCalorias.model.Food;
import com.example.calculadoraDeCalorias.model.Ingredient;
import com.example.calculadoraDeCalorias.repository.FoodRepository;
import com.example.calculadoraDeCalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService{

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Integer totalCalories(String nameFood) {
        List<Ingredient> ingredients = ingredientsFromFood(nameFood);
        return ingredients.stream().mapToInt(Ingredient::getCalories).sum();
    }

    @Override
    public List<Ingredient> ingredientsFromFood(String nameFood) {
        Food food = foodRepository.findByName(nameFood);
        if(food == null)
            return new ArrayList<>();
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<Ingredient> ingredientsFood = new ArrayList<>();
        for(String ingredient: food.getIngredients()){
            ingredientsFood.add(ingredients.stream().filter(ingredientName -> ingredientName.getName().equalsIgnoreCase(ingredient)).findFirst().orElse(null));
        }
        return ingredientsFood;
    }

    @Override
    public Ingredient ingredientWithTheMostCalories(String nameFood) {
        List<Ingredient> ingredients = ingredientsFromFood(nameFood);
        return ingredients.stream().max(Comparator.comparingInt(Ingredient::getCalories)).get();
    }
}
