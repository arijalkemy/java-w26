package com.meli.calculadoraDeCalorias.service;

import com.meli.calculadoraDeCalorias.dto.DishInputDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.model.Dish;

public interface IDishService {
    DishResponseDTO getDishInfo(String name, double weight);
    void saveDish(DishInputDTO dish);
}
