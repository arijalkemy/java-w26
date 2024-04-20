package com.meli.calculadorcalorias.repository;

import com.meli.calculadorcalorias.dto.DishReturnDTO;
import com.meli.calculadorcalorias.dto.IngredientsDTO;
import com.meli.calculadorcalorias.model.Ingredients;

import java.util.List;

public interface IngredientsRepository {

    public List<IngredientsDTO> searchIngredients(List<IngredientsDTO> ingredientsList) throws Error;
    public Ingredients searchIngredient(String name) throws Error;
    public void createDish(DishReturnDTO dish);
    public DishReturnDTO getDish(String name);




}