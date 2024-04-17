package org.example.pact_exc_p2_calories_calc.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IngredientDTO implements Serializable {
    private String name;
    private int calories;
}
