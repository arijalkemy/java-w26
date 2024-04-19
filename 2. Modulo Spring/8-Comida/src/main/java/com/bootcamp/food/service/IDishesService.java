package com.bootcamp.food.service;

import com.bootcamp.food.dto.DishResponseDTO;

public interface IDishesService {
    DishResponseDTO searchDishByNameAndWeight(String name, Double weight);
}
