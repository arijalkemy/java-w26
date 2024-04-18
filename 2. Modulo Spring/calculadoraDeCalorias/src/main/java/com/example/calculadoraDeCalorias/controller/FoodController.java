package com.example.calculadoraDeCalorias.controller;

import com.example.calculadoraDeCalorias.model.Ingredient;
import com.example.calculadoraDeCalorias.service.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodServiceImpl foodService;

    @GetMapping("/allingredients/{foodName}")
    public List<Ingredient> ingredientsFromFood(@PathVariable String foodName){
        return foodService.ingredientsFromFood(foodName);
    }

    @GetMapping("/ingredient/{foodName}")
    public Ingredient ingredientWithMostCalories(@PathVariable String foodName){
        return foodService.ingredientWithTheMostCalories(foodName);
    }

    @GetMapping("/")
    public Integer totalCalories(@RequestParam String foodName){
        return foodService.totalCalories(foodName);
    }
}
