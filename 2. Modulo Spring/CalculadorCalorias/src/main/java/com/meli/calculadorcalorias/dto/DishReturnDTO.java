package com.meli.calculadorcalorias.dto;

import java.util.List;

public class DishReturnDTO {
    private String name;
    private List<IngredientsReturnDTO> listIngredients;
    private double totalCalories;

    public DishReturnDTO(String name, List<IngredientsReturnDTO> listIngredients, double totalCalories) {
        this.name = name;
        this.listIngredients = listIngredients;
        this.totalCalories = totalCalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientsReturnDTO> getListIngredients() {
        return listIngredients;
    }

    public void setListIngredients(List<IngredientsReturnDTO> listIngredients) {
        this.listIngredients = listIngredients;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
}
