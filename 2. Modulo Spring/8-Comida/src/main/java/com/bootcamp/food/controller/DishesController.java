package com.bootcamp.food.controller;

import com.bootcamp.food.dto.DishResponseDTO;
import com.bootcamp.food.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishesController {
    @Autowired
    IDishesService iDishesService;
    @GetMapping
    public DishResponseDTO getDishByNameAndWeight(@RequestParam String name, @RequestParam Double weight) {
        return iDishesService.searchDishByNameAndWeight(name, weight);
    }
}
