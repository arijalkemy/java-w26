package org.example.pact_exc_p2_calories_calc.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class DishRequestDTO implements Serializable {
    private String name;
    private List<IngredientDTO> ingredients;
}
