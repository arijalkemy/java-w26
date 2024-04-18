package org.ggomezr.calculadoradecalorias.application.controller;

import org.ggomezr.calculadoradecalorias.application.service.impl.FoodService;
import org.ggomezr.calculadoradecalorias.domain.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService ingredientsService;

    @GetMapping("/getAllIngredients")
    public List<Food> getAllIngredients() throws IOException {
        return ingredientsService.getAllIngredients();
    }
}
