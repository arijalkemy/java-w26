package com.meli.calculadoracalorias.dto;

import com.meli.calculadoracalorias.entity.Ingredient;

import java.util.List;

public class FoodDTO {
    List<Ingredient> listOfIngredients;
    int totalCalories;
    Ingredient ingWithMostCaloreis;

    public FoodDTO(List<Ingredient> listOfIngredients, int totalCalories, Ingredient ingWithMostCaloreis) {
        this.listOfIngredients = listOfIngredients;
        this.totalCalories = totalCalories;
        this.ingWithMostCaloreis = ingWithMostCaloreis;
    }

    public List<Ingredient> getListOfIngredients() {
        return listOfIngredients;
    }

    public void setListOfIngredients(List<Ingredient> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Ingredient getIngWithMostCaloreis() {
        return ingWithMostCaloreis;
    }

    public void setIngWithMostCaloreis(Ingredient ingWithMostCaloreis) {
        this.ingWithMostCaloreis = ingWithMostCaloreis;
    }
}
