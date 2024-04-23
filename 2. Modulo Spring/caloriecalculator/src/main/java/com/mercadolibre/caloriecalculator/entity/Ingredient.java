package com.mercadolibre.caloriecalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories;
}
