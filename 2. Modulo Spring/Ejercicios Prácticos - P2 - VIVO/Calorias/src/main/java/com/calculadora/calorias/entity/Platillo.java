package com.calculadora.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Platillo {
    private String name;
    private int weight;
    private List<Ingrediente> ingredients;
    private int totalCalories;
    private Ingrediente ingredienteMasCalorico;

}
