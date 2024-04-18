package org.bootcamp.calorias.controller;

import org.bootcamp.calorias.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired()
    private IngredientService ingredientService;

    @GetMapping("")
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(ingredientService.getAll());
    }

}
