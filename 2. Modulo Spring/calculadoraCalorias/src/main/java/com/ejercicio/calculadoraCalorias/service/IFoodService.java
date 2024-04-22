package com.ejercicio.calculadoraCalorias.service;

import com.ejercicio.calculadoraCalorias.model.Dish;
import com.ejercicio.calculadoraCalorias.model.Food;

import java.util.List;

public interface IFoodService {

    public List<Dish> getDish(String dishName, double weight);
}
