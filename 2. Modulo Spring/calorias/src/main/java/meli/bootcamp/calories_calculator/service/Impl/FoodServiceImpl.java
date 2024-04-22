package meli.bootcamp.calories_calculator.service.Impl;

import java.util.List;
import meli.bootcamp.calories_calculator.domain.Dish;
import meli.bootcamp.calories_calculator.domain.Food;
import meli.bootcamp.calories_calculator.repository.IDishRepository;
import meli.bootcamp.calories_calculator.repository.IFoodRepository;
import meli.bootcamp.calories_calculator.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements IFoodService {
  IDishRepository dishRepository;

  @Autowired
  FoodServiceImpl(IDishRepository dishRepository) {
    this.dishRepository = dishRepository;
  }

  @Override
  public List<Dish> getAll() {
    return dishRepository.getAll();
  }

  @Override
  public Integer getCalories(String foodName) {
    return dishRepository.getCalories(foodName);
  }

  @Override
  public Food getMaxCalories(String name) {
    return dishRepository.getByName(name).ingredientWithMaxCalories().getKey();
  }

}
