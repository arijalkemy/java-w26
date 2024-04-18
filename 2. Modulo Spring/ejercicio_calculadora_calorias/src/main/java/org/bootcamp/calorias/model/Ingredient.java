package org.bootcamp.calorias.model;

import lombok.Data;

@Data
public class Ingredient {

    public static final Integer WEIGHT_CALORIES = 100;

    private String name;
    private Integer calories;

}
