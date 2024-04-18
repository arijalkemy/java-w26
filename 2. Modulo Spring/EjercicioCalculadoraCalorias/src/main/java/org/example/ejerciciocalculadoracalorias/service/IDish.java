package org.example.ejerciciocalculadoracalorias.service;

import org.example.ejerciciocalculadoracalorias.dto.DishDTO;
import org.example.ejerciciocalculadoracalorias.dto.IngredientsDTO;

import java.util.List;

public interface IDish {
    public Double calculateTotalDishCalories(String nameDish);
    public List<IngredientsDTO> searchTotalIngredients(String nameDish);
    public IngredientsDTO searchMostCaloriesIngredients(String nameDish);

    public List<DishDTO> searchAllDishes();
}
