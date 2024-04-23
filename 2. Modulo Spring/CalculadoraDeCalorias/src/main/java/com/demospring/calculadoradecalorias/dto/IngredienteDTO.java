package com.demospring.calculadoradecalorias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredienteDTO {
    private String name;
    private int calories;

    public IngredienteDTO(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
}
