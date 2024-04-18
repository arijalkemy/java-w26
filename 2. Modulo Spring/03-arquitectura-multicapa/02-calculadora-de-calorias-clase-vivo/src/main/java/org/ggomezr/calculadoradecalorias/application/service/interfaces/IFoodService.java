package org.ggomezr.calculadoradecalorias.application.service.interfaces;

import org.ggomezr.calculadoradecalorias.domain.dto.DishDTO;
import org.ggomezr.calculadoradecalorias.domain.entity.Dish;
import org.ggomezr.calculadoradecalorias.domain.entity.Food;

import java.io.IOException;
import java.util.List;

public interface IFoodService {
    List<Food> getAllIngredients() throws IOException;
    int getDishTotalCalories(Dish dish, int grams);
    Food getDishHigherCaloriesIngredient(Dish dish);
}
