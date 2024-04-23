package com.mercadolibre.caloriecalculator.controller;

import com.mercadolibre.caloriecalculator.entity.Ingredient;
import com.mercadolibre.caloriecalculator.service.IIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "ingredient")
@RequiredArgsConstructor
public class IngredientController {
    private final IIngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

}
