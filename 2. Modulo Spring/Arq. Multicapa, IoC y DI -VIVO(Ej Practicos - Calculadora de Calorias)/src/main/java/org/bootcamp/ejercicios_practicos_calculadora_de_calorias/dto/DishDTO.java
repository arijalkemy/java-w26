package org.bootcamp.ejercicios_practicos_calculadora_de_calorias.dto;

import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.entity.Ingredient;

import java.util.List;

public class DishDTO {
    private String dishName;
    private List<Ingredient> ingredients;

    public DishDTO(String dishName, List<Ingredient> ingredients) {
        this.dishName = dishName;
        this.ingredients = ingredients;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
