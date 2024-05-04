package com.meli.calculadorcalorias.controller;

import com.meli.calculadorcalorias.dto.DishDTO;
import com.meli.calculadorcalorias.dto.DishReturnDTO;
import com.meli.calculadorcalorias.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping("/calculateCalories")
    public ResponseEntity<DishReturnDTO> calculateCalories(@RequestBody DishDTO dish) {
        return ResponseEntity.ok(ingredientsService.ReturnDish(dish));
    }


    @GetMapping("/getDish/{name}")
    public ResponseEntity<DishReturnDTO> getDish(@PathVariable String name) {
        return ResponseEntity.ok(ingredientsService.getDish(name));
    }

}
