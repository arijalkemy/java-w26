package org.example.calculadora_calorias.controller;

import org.example.calculadora_calorias.dto.EntryFoodList;
import org.example.calculadora_calorias.dto.FoodDTO;
import org.example.calculadora_calorias.model.Food;
import org.example.calculadora_calorias.service.FoodServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodServiceI foodService;

    @GetMapping("find")
    public ResponseEntity<FoodDTO> findFood(@RequestParam String name){
        return new ResponseEntity<>(foodService.getFoodInfo(name), HttpStatus.OK);
    }

    @PostMapping("find/list")
    public ResponseEntity<List<FoodDTO>> findFoodList(@RequestBody EntryFoodList foodNames){
        return new ResponseEntity<>(foodService.getFoodListByNames(foodNames), HttpStatus.OK);
    }


}
