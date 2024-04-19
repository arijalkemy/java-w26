package com.example.calculadora.calculadora_calorias.controller;

import com.example.calculadora.calculadora_calorias.entity.Ingredient;
import com.example.calculadora.calculadora_calorias.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngridientController {

    IngredientService ingredientService;

    @Autowired
    public IngridientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAll(){
        List<Ingredient> response = ingredientService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
