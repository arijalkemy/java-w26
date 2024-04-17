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

    public Dish(String name, List<Ingredient> ingredientList){
        this.name = name;
        this.ingredientList = ingredientList;
    }

}
