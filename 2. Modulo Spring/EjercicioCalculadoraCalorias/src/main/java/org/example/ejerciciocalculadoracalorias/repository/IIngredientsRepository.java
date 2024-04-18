package org.example.ejerciciocalculadoracalorias.repository;

import org.example.ejerciciocalculadoracalorias.entity.Ingredients;

import java.util.List;

public interface IIngredientsRepository {
    public List<Ingredients> findAllIngredients();
    public Ingredients findOne(String name);
}
