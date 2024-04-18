package com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.entity;

public class Ingrediente {
    private String name;
    private Integer calories;

    public Ingrediente(String name, Integer calories) {
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
