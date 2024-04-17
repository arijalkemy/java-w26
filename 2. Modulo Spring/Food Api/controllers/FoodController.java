package org.example.calories.controllers;

import org.example.calories.dto.FoodIngredientDto;
import org.example.calories.entities.Food;
import org.example.calories.services.IFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final IFood iFood;

    public FoodController(@Autowired IFood iFood) {
        this.iFood = iFood;
    }

    @GetMapping("/{name}/{weigth}")
    public ResponseEntity<FoodIngredientDto> getFoodByName(@PathVariable String name, @PathVariable String weigth) {
        return ResponseEntity.ok(this.iFood.findByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getFoods() {
        return ResponseEntity.ok(this.iFood.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<List<FoodIngredientDto>> getFoodByName(@RequestParam String... dish) {
        return ResponseEntity.ok(this.iFood.foodIngredientDtoList(dish));
    }
}
