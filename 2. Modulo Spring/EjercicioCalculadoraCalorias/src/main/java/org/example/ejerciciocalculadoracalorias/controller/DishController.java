package org.example.ejerciciocalculadoracalorias.controller;

import org.example.ejerciciocalculadoracalorias.dto.DishDTO;
import org.example.ejerciciocalculadoracalorias.dto.IngredientsDTO;
import org.example.ejerciciocalculadoracalorias.service.IDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    IDish dishService;

    @GetMapping("/getCalculateCalories/{dishName}")
    public ResponseEntity<Double> getCalculateCalories(@PathVariable String dishName){
        return new ResponseEntity<>(dishService.calculateTotalDishCalories(dishName), HttpStatus.OK);
    }

    @GetMapping("/getTotalIngredients/{dishName}")
    public ResponseEntity<List<IngredientsDTO>> getTotalIngredients(@PathVariable String dishName){
        return new ResponseEntity<>(dishService.searchTotalIngredients(dishName), HttpStatus.OK);
    }

    @GetMapping("/getMostCaloriesIngredients/{dishName}")
    public ResponseEntity<IngredientsDTO> getMostCaloriesIngredients(@PathVariable String dishName){
        return new ResponseEntity<>(dishService.searchMostCaloriesIngredients(dishName), HttpStatus.OK);
    }

    @GetMapping("/getDishList")
    public ResponseEntity<List<DishDTO>> getDishList(){
        return new ResponseEntity<>(dishService.searchAllDishes(), HttpStatus.OK);
    }
}
