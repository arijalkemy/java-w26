package org.example.calculadora_calorias.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.calculadora_calorias.dto.IngredientDTO;
import org.example.calculadora_calorias.dto.PlateDTO;
import org.example.calculadora_calorias.model.Ingredient;
import org.example.calculadora_calorias.model.Plate;
import org.example.calculadora_calorias.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class PlateController {
    @Autowired
    IRestaurantService restaurantService;

    @GetMapping("/calories/{plateName}")
    public ResponseEntity<Integer> getCalories(@PathVariable String plateName) {
        return ResponseEntity.ok(restaurantService.plateCalories(plateName));
    }

    @GetMapping("/ingredients/{plateName}")
    public ResponseEntity<Plate> getIngredients(@PathVariable String plateName) {
        return ResponseEntity.ok(restaurantService.listOfIngredients(plateName));
    }
    @GetMapping("/maxCalories/{plateName}")
    public ResponseEntity<Ingredient> getMaxCalories(@PathVariable String plateName) {
        return ResponseEntity.ok(restaurantService.ingredientCalories(plateName));
    }
    @GetMapping("/platesCalories/{platesNames}")
    public ResponseEntity<List<PlateDTO>> getPlatesCalories(@PathVariable String platesNames){
        return ResponseEntity.ok(restaurantService.platesCalories(platesNames));
    }
}
