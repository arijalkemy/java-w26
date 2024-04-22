package meli.bootcamp.calories_calculator.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import meli.bootcamp.calories_calculator.domain.Dish;
import meli.bootcamp.calories_calculator.repository.IDishRepository;
import meli.bootcamp.calories_calculator.repository.IFoodRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DishRepositoryImpl implements IDishRepository {
  List<Dish> dishes;
  IFoodRepository repository;

  DishRepositoryImpl(IFoodRepository repository) {
    this.dishes = getRandomDishes(repository);
    this.repository = repository;
  }

  private static List<Dish> getRandomDishes(IFoodRepository repository) {
    List<Dish> dishes = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      dishes.add(new Dish(
          "dish" + i,
          Map.of(
              repository.getAll().get(new Random().nextInt(100)),
              new Random().nextInt(200) + 50,

              repository.getAll().get(new Random().nextInt(100)),
              new Random().nextInt(200) + 50
          )

          )
      );
    }
    return dishes;
  }

  @Override
  public List<Dish> getAll() {
    return dishes;
  }

  @Override
  public Integer getCalories(String name) {
    return dishes.stream()
        .filter(d -> d.getName().equalsIgnoreCase(name))
        .mapToInt(Dish::getCalories).sum();
  }

  @Override
  public Dish getByName(String name) {
    return dishes.stream()
        .filter(d -> d.getName().equalsIgnoreCase(name)).findFirst().orElseThrow();
  }


}
