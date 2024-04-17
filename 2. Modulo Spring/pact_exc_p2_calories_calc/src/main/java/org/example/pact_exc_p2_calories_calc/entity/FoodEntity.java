package org.example.pact_exc_p2_calories_calc.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodEntity {
    private String name;
    private int calories;

    public FoodEntity(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
}
