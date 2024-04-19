package com.bootcamp.food.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Dish {
    private String name;
    private Double weight;
    private List<Ingredient> ingredients;

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", ingredients=" + ingredients +
                '}';
    }
}
