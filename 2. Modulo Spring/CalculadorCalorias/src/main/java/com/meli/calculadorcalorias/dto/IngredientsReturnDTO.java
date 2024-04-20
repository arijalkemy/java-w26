package com.meli.calculadorcalorias.dto;

public class IngredientsReturnDTO {

    private String name;
    private double calories;
    private double weight;
    private double totalCalories;


    public IngredientsReturnDTO(String name, double calories, double weight, double totalCalories) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.totalCalories = totalCalories;
    }


    public IngredientsReturnDTO(String name,double calories) {
        this.calories = calories;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
}
