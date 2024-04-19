package org.example.integradorcaloriescalculator.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.integradorcaloriescalculator.entity.Ingredient;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class DishResponseDTO {

    private String dishName;
    private double totalCalories;
    private List<Ingredient> dishIngredients;
    private Ingredient highestCalIngredient;

    public DishResponseDTO(){}

}
