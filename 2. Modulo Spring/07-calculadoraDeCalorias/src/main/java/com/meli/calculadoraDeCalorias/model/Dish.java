package com.meli.calculadoraDeCalorias.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Dish {
    private String name;
    private List<Ingredient> ingredientList;
    private Double weight;

    public Dish(String name, List<Ingredient> ingredientList,Double weight){
        this.name = name;
        this.ingredientList = ingredientList;
        this.weight = weight;
    }

}
