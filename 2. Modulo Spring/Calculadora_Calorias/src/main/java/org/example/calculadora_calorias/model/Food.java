package org.example.calculadora_calorias.model;

import lombok.Data;

import java.util.List;

@Data
public class Food {
    private List<Ingredient> ingredients;
    private String name;

    public Food(List<Ingredient> ingredients, String name) {
        this.ingredients = ingredients;
        this.name = name;
    }
}
