package org.bootcamp.ejercicios_practicos_calculadora_de_calorias.entity;

public class Ingredient {
    private String name;
    private int calories;

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
