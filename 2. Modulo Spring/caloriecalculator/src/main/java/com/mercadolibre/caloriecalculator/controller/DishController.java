package com.mercadolibre.caloriecalculator.controller;

import com.mercadolibre.caloriecalculator.entity.Dish;
import com.mercadolibre.caloriecalculator.service.imp.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping(path = "dish")
    public ResponseEntity<Void> postDish(Dish dish) {
        dishService.registerDish(dish);
        return ResponseEntity.ok().build();
    }
}
