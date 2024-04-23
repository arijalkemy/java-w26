package com.ejercicio.calculadoraCalorias.service;

import com.ejercicio.calculadoraCalorias.dto.DishDTO;
import com.ejercicio.calculadoraCalorias.model.Dish;
import com.ejercicio.calculadoraCalorias.model.Food;

import java.util.List;

public interface IFoodService {

    public DishDTO getDish(String dishName, double weight);
}
