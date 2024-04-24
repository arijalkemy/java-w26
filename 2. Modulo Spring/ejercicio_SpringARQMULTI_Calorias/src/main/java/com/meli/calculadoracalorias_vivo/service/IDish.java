package com.meli.calculadoracalorias_vivo.service;

import com.meli.calculadoracalorias_vivo.dto.DishDTO;
import com.meli.calculadoracalorias_vivo.dto.IngredientsDTO;

import java.util.List;

public interface IDish {
    public Double calculateTotalDishCalories(String nameDish);
    public List<IngredientsDTO> searchTotalIngredients(String nameDish);
    public IngredientsDTO searchMostCaloriesIngredients(String nameDish);

    public List<DishDTO> searchAllDishes();
}
