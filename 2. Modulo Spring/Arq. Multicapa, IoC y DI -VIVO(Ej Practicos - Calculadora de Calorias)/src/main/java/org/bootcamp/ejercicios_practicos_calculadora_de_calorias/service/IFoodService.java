package org.bootcamp.ejercicios_practicos_calculadora_de_calorias.service;

import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.dto.DishDTO;

public interface IFoodService {
    public int getCalories(DishDTO dish);
}
