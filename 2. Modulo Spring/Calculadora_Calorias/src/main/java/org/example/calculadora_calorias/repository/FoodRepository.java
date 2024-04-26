package org.example.calculadora_calorias.repository;

import org.example.calculadora_calorias.dto.EntryFoodList;
import org.example.calculadora_calorias.dto.FoodDTO;
import org.example.calculadora_calorias.model.Food;
import org.example.calculadora_calorias.model.Ingredient;

import java.util.List;

public interface FoodRepository {
    public Food getFoodByName(String foodName);
    List<Food> getFoodListByNames(EntryFoodList foodNames);
}
