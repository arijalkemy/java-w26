package com.bootcamp.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class DishResponseDTO implements Serializable {
    private String name;
    private Double weight;
    private List<IngredientResponseDTO> ingredients;
    private String mostCaloriesIngredient;
}
