package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.dto.FoodDTO;

import java.util.List;

public interface IFood {
    FoodDTO food(String name);
    List<FoodDTO> foodList();
}
