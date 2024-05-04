package com.meli.calculadorcalorias.dto;

import java.util.List;

public class DishDTO {
    private String name;
    private List<IngredientsDTO> ingredients;


    public DishDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientsDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
