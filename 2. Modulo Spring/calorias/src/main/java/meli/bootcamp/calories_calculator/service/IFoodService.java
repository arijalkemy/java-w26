package meli.bootcamp.calories_calculator.service;

import java.util.List;
import meli.bootcamp.calories_calculator.domain.Dish;
import meli.bootcamp.calories_calculator.domain.Food;

public interface IFoodService {
  List<Dish> getAll();
  Integer getCalories(String foodName);
  Food getMaxCalories(String name);
}
