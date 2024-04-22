package meli.bootcamp.calories_calculator.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Dish {
  String name;
  Map<Food, Integer> ingredients = new HashMap<>();


  public void addIngredientWithGrames(Food food, Integer grames) {
    ingredients.put(food, grames);
  }

  public Integer calculateTotalCalories(Food food, Integer grames) {
    return food.getCalories() * grames / 100;
  }

  public Integer getCalories() {
    return ingredients.entrySet().stream()
        .mapToInt((food) -> calculateTotalCalories(food.getKey(), food.getValue()))
        .sum();
  }

  public Map.Entry<Food, Integer> ingredientWithMaxCalories() {
    return this.ingredients.entrySet().stream().max(
        Comparator.comparing(f -> calculateTotalCalories(f.getKey(), f.getValue()))
    ).orElseGet(null);
  }

}
