package org.example.calculadora_calorias.repository;

import org.example.calculadora_calorias.model.Ingredient;

import java.util.*;

public interface IIngredientRepository {
    public List<Ingredient> findAll();
    public Ingredient findByName(String name);
}
