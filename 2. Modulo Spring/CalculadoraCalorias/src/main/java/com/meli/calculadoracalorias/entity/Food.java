package com.meli.calculadoracalorias.entity;

import java.util.List;

public class Food {
    List<Ingredient> ListOfIngredients;
    String name;

    public Food(List<Ingredient> listOfIngredients, String name) {
        ListOfIngredients = listOfIngredients;
        this.name = name;
    }

    public List<Ingredient> getListOfIngredients() {
        return ListOfIngredients;
    }

    public void setListOfIngredients(List<Ingredient> listOfIngredients) {
        ListOfIngredients = listOfIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
