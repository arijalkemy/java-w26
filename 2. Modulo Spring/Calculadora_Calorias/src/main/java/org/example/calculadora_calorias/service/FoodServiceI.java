package org.example.calculadora_calorias.service;

import org.example.calculadora_calorias.dto.EntryFoodList;
import org.example.calculadora_calorias.dto.FoodDTO;
import org.example.calculadora_calorias.model.Food;

import java.util.List;

public interface FoodServiceI {
    FoodDTO getFoodInfo(String foodName);

    List<FoodDTO> getFoodListByNames(EntryFoodList foodNames);
}
