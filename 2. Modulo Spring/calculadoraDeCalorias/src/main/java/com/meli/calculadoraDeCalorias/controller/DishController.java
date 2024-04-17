package com.meli.calculadoraDeCalorias.controller;

import com.meli.calculadoraDeCalorias.dto.DishInputDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.model.Dish;
import com.meli.calculadoraDeCalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private IDishService dishService;

    @GetMapping("/calculateCalories/{name}/{weight}")
    public ResponseEntity<DishResponseDTO> getDishInfo(
            @PathVariable String name, @PathVariable double weight){
        DishResponseDTO response;
        try {
            response = dishService.getDishInfo(name, weight);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/saveDish")
    public ResponseEntity<Void> saveDish(@RequestBody DishInputDTO dish){
        dishService.saveDish(dish);
        return ResponseEntity.ok().build();
    }
}
