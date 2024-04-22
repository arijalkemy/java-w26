package com.ejercicio.calculadoraCalorias.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Dish {

    public Dish(String name, double weight, List<Food> foodList) {
        this.name = name;
        this.weight = weight;
        this.foodList = foodList;
    }

    String name;
    double weight;
    List<Food> foodList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
