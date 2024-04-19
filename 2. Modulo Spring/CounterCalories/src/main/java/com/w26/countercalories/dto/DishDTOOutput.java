package com.w26.countercalories.dto;

import com.w26.countercalories.entity.Ingredient;
import com.w26.countercalories.entity.IngredientDish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class DishDTOOutput implements Serializable {
    private int weightInGrams;
    private float totalCalories;
    private IngredientDish ingredientDishList;
    private Ingredient majorCalories;

    public DishDTOOutput(){}
}

