package org.bootcamp.calorias.controller;

import org.bootcamp.calorias.dto.DishDTO;
import org.bootcamp.calorias.service.ICaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesCalculatorController {
    @Autowired private ICaloriesCalculatorService caloriesCalculatorService;

    @GetMapping("/calculateCalories")
    public DishDTO calculateDishCalories(@RequestParam String name, @RequestParam int weight) {
        return caloriesCalculatorService.calculateDishCalories(name, weight);
    }
}
