package meli.bootcamp.calories_calculator.repository;

import java.util.List;
import meli.bootcamp.calories_calculator.domain.Dish;

public interface IDishRepository {
  List<Dish> getAll();
  Integer getCalories(String name);
  Dish getByName(String name);
}
