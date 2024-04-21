package org.example.calculadora_calorias.service;

import org.example.calculadora_calorias.dto.IngredientDTO;
import org.example.calculadora_calorias.dto.PlateDTO;
import org.example.calculadora_calorias.model.Ingredient;
import org.example.calculadora_calorias.model.Plate;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface IRestaurantService {
    public Integer plateCalories(String plate);
    public Plate listOfIngredients(String plate);
    public Ingredient ingredientCalories(String plate);
    public List<PlateDTO> platesCalories(String plates);

}
