package com.javabootcamp.calorias.dto;

import com.javabootcamp.calorias.model.Food;
import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    List<IngredientDTO> foodList;

}
