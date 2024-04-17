package com.spring.calorias.controller;

import com.spring.calorias.dto.DishRequestDTO;
import com.spring.calorias.dto.DishResponseDTO;
import com.spring.calorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    IDishService dishService;

    @PostMapping("/calculateDishCalories")
    ResponseEntity<DishResponseDTO> getDishCalories(@RequestBody DishRequestDTO dishRequest) {
        return new ResponseEntity<>(dishService.calculateDishCalories(dishRequest), HttpStatus.OK);
    }

    @PostMapping("/calculateAllDishesCalories")
    ResponseEntity<List<DishResponseDTO>> getAllCalories(@RequestBody List<DishRequestDTO> dishesRequest) {
        return new ResponseEntity<>(dishService.calculateAllDishesCalories(dishesRequest), HttpStatus.OK);
    }

}
