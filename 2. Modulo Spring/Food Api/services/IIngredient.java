package org.example.calories.services;

import org.example.calories.entities.Ingredient;

public interface IIngredient {
    Ingredient findByName(String name);
}
