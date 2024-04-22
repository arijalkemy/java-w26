package meli.bootcamp.calories_calculator.controller;

import java.util.List;
import meli.bootcamp.calories_calculator.domain.Dish;
import meli.bootcamp.calories_calculator.domain.Food;
import meli.bootcamp.calories_calculator.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {
  IFoodService foodService;

  @Autowired
  FoodController(IFoodService foodService) {
    this.foodService = foodService;
  }

  @GetMapping
  public ResponseEntity<List<Dish>> getAll() {
    return ResponseEntity.ok().body(foodService.getAll());
  }

  @GetMapping("/{name}")
  public ResponseEntity<Integer> getCalories(@PathVariable String name) {
    return ResponseEntity.ok().body(foodService.getCalories(name));
  }

  @GetMapping("/{name}/max")
  public ResponseEntity<Food> getMaxCalories(@PathVariable String name) {
    return  ResponseEntity.ok().body(foodService.getMaxCalories(name));
  }
}
