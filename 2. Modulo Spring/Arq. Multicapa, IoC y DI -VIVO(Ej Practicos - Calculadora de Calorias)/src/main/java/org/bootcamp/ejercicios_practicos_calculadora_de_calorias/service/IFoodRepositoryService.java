package org.bootcamp.ejercicios_practicos_calculadora_de_calorias.service;

import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.entity.Ingredient;

import java.util.List;

public interface IFoodRepositoryService {
    public List<Ingredient> getAllIngredients();
}
