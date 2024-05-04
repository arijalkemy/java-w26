package com.meli.calculadorcalorias.dto;

public class IngredientsDTO {
    private String name;
    private double weight;



    public IngredientsDTO(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
