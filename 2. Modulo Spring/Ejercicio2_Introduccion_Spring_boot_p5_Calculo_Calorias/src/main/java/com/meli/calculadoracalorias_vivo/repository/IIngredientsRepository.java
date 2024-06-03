package com.meli.calculadoracalorias_vivo.repository;

import com.meli.calculadoracalorias_vivo.entity.Ingredients;

import java.util.List;

public interface IIngredientsRepository {
    public List<Ingredients> findAllIngredients();
    public Ingredients findOne(String name);
}
