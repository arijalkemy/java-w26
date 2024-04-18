package com.example.calculadoraDeCalorias.service;

import com.example.calculadoraDeCalorias.model.Ingredient;

import java.util.List;

public interface IFoodService {

    Integer totalCalories(String nameFood);
    List<Ingredient> ingredientsFromFood(String nameFood);
    Ingredient ingredientWithTheMostCalories(String nameFood);
}
