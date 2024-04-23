package com.mercadolibre.caloriecalculator.service;

import com.mercadolibre.caloriecalculator.entity.Ingredient;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> findAll();
}
