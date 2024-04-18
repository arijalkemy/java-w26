package org.bootcamp.calorias.model;

import lombok.Data;

import java.util.List;

@Data
public class Dish {

    private String name;
    private List<Ingredient> ingredients;

}
