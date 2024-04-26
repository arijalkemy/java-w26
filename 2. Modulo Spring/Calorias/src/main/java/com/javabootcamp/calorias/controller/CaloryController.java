package com.javabootcamp.calorias.controller;

import com.javabootcamp.calorias.dto.CaloriesResponseDTO;
import com.javabootcamp.calorias.dto.Recipe;
import com.javabootcamp.calorias.model.Food;
import com.javabootcamp.calorias.service.CaloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloryController {

    @Autowired
    Calory caloryService;


    @GetMapping("/calories")
    public ResponseEntity<List<Food>> findAll(){
        return ResponseEntity.ok(caloryService.getAllIngredientes());
    }

    @PostMapping("/calories")
    public ResponseEntity<CaloriesResponseDTO> getRecipeInfo(@RequestBody Recipe recipe){
        return ResponseEntity.ok(caloryService.getRecipeInfo(recipe));
    }

    @PostMapping("listCalories")
    public ResponseEntity<List<CaloriesResponseDTO>> getRecipesInfo(@RequestBody List<Recipe> recipes){
        return ResponseEntity.ok(caloryService.getRecipesInfo(recipes));
    }

}
