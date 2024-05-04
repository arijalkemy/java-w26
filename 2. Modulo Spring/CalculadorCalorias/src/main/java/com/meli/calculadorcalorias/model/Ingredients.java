package com.meli.calculadorcalorias.model;

public class Ingredients {
    private String name;
    private double calories;

    public Ingredients() {
        // Constructor sin argumentos
    }

    // Constructor con argumentos
    public Ingredients(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    // Getters y setters
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
}
