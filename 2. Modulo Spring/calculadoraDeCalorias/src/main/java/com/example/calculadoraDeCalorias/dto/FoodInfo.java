package com.example.calculadoraDeCalorias.dto;

import com.example.calculadoraDeCalorias.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodInfo {

    private String name;
    private List<Ingredient> ingredients;
    private Integer totalWeight;
    private Integer totalCalories;
}
