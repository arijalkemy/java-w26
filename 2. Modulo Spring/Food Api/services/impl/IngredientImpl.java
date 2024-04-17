package org.example.calories.services.impl;

import org.example.calories.entities.Food;
import org.example.calories.entities.Ingredient;
import org.example.calories.repositories.IngredientRepository;
import org.example.calories.services.IIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientImpl implements IIngredient {
    private final IngredientRepository ingredientRepository;

    public IngredientImpl(@Autowired IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientRepository.getIngredients()
                .stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
