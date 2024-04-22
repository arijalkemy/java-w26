package com.ejercicio.calculadoraCalorias.repository;

import com.ejercicio.calculadoraCalorias.model.Dish;
import com.ejercicio.calculadoraCalorias.model.Food;

import java.util.List;

public interface IFoodRepository {

    public List<Food> getAll();
    public List<Dish> getDishList();
}
