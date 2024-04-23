package com.mercadolibre.caloriecalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
}
