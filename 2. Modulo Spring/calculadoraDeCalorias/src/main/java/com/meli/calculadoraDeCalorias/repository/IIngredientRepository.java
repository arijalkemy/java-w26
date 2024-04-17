package com.meli.calculadoraDeCalorias.repository;

import com.meli.calculadoraDeCalorias.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {

    List<Ingredient> getAll();

    Ingredient getByName(String name);
}
