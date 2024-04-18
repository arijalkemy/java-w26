package com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity;

import java.security.PrivateKey;

public class Ingredientes {
    private String name;
    private Integer calories;

    public Ingredientes() {
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
