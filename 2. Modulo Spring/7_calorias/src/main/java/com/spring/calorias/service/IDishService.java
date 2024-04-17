package com.spring.calorias.service;

import com.spring.calorias.dto.DishRequestDTO;
import com.spring.calorias.dto.DishResponseDTO;
import com.spring.calorias.entity.Ingredient;

import java.util.List;

public interface IDishService {

    Ingredient findIngredientByName(String name);

    List<DishResponseDTO> calculateAllDishesCalories(List<DishRequestDTO> dishesRequest);

    DishResponseDTO calculateDishCalories(DishRequestDTO dishRequest);
}
