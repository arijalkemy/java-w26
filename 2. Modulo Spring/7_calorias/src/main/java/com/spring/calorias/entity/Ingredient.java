package com.spring.calorias.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {

    private String name;
    private Integer calories;

    public Ingredient(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public Ingredient() {}
}
