package com.meli.calculadoracalorias_vivo.entity;

public class Ingredients {
    private String name;
    private Integer calories;

    public Ingredients() {
    }

    public Ingredients(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
