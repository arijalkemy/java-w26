package meli.bootcamp.calories_calculator.repository;

import java.util.List;
import meli.bootcamp.calories_calculator.domain.Food;

public interface IFoodRepository {
  List<Food> getAll();
  Food findByName(String name);
}
