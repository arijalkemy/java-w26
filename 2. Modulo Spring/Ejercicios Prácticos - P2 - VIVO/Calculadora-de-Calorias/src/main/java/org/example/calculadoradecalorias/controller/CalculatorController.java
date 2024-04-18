package org.example.calculadoradecalorias.controller;

import org.example.calculadoradecalorias.dto.DishDTO;
import org.example.calculadoradecalorias.dto.ResponseDTO;
import org.example.calculadoradecalorias.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculatorController {
    @Autowired
    IDishesService dishesService;

    @PostMapping("/calculate")
    ResponseEntity<ResponseDTO> calculate(@RequestBody DishDTO dish) {
        return new ResponseEntity<>(dishesService.calculateCalories(dish),HttpStatus.OK);
    }

    @PostMapping("/calculate_dishes")
    ResponseEntity<List<ResponseDTO>> calculateDishes(@RequestBody List<DishDTO> dishes) {
        return new ResponseEntity<>(dishesService.calculateCalories(dishes),HttpStatus.OK);
    }
}
