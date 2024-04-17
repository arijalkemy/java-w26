package com.meli.calculadoraDeCalorias.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class IngredientDTO implements Serializable {
    private String name;
    private Integer calories;

    public IngredientDTO(String name, Integer calories){
        this.name = name;
        this.calories = calories;
    }
}
