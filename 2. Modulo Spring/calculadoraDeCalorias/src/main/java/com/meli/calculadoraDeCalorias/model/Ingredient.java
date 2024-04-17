package com.meli.calculadoraDeCalorias.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Ingredient {
    private String name;
    private Integer calories;

    public Ingredient() {
    }

    public Ingredient(String name, Integer calories){
        this.name = name;
        this.calories = calories;
    }

}
