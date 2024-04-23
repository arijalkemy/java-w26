package com.mercadolibre.CalculadoraDeCalorias.dto;

import com.mercadolibre.CalculadoraDeCalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {
    private String nameDish;
    private List<Ingredient> listIngredients;
    private String highestCalorieIngredient;
    private double totalCaloriesDish;
}
