package org.bootcamp.calorias.service;

import org.bootcamp.calorias.dto.DishDTO;

public interface ICaloriesCalculatorService {
    public DishDTO calculateDishCalories(String name, int weight);
}
