package org.bootcamp.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DishDTO {
    private String name;
    private Integer totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO mostCaloricIngredient;

}
