package com.example.calculadora.calculadora_calorias.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ingredient {
   private String name;
   private Integer calories;

    public Ingredient(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public Ingredient() {
    }
}
