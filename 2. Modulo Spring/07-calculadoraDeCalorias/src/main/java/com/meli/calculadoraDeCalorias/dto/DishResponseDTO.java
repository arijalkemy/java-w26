package com.meli.calculadoraDeCalorias.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class DishResponseDTO implements Serializable {
    private Integer totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO mostCaloric;

    public DishResponseDTO(Integer totalCalories, List<IngredientDTO> ingredients, IngredientDTO mostCaloric) {
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
        this.mostCaloric = mostCaloric;
    }

    public DishResponseDTO() {

    }
}
