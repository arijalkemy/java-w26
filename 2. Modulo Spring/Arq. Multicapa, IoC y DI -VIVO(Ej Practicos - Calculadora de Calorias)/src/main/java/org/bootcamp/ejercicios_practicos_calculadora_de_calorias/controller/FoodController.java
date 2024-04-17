package org.bootcamp.ejercicios_practicos_calculadora_de_calorias.controller;

import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.dto.DishDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {
    @GetMapping("/")
    ResponseEntity<?> getIngredientsFromDish(@RequestBody DishDTO dishDTO) {
        return ResponseEntity.ok("");
    }
}
