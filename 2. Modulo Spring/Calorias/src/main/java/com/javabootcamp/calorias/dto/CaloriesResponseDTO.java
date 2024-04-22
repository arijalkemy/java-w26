package com.javabootcamp.calorias.dto;

import com.javabootcamp.calorias.model.Food;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Data
public class CaloriesResponseDTO {
    double totalCalories;
    List<IngredientDTO> foodList = new ArrayList<>();
    IngredientDTO biggestCalory;

}
