package org.example.pact_exc_p2_calories_calc.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.pact_exc_p2_calories_calc.entity.FoodEntity;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DishResponseDTO implements Serializable {
    private int totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO greatestCalIngredient;
}
