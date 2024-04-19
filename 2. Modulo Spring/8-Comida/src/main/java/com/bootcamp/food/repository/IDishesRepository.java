package com.bootcamp.food.repository;

import com.bootcamp.food.entities.Dish;
import com.bootcamp.food.entities.Ingredient;

import java.util.List;

public interface IDishesRepository {
    List<Dish> findAll();
}
