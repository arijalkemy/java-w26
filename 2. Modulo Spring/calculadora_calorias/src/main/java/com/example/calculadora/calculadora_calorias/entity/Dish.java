package com.example.calculadora.calculadora_calorias.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


public class Dish {
 private String name;
 private Integer weight;
 private List<Ingredient> ingredients;

    public Dish(String name, Integer weight, List<Ingredient> ingredients) {
        this.name = name;
        this.weight = weight;
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "ingredients=" + ingredients +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
