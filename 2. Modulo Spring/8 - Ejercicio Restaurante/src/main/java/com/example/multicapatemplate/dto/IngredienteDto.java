package com.example.multicapatemplate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class IngredienteDto {
    final private String name;
    final private double caloriasTotales;

    public IngredienteDto(double caloriasTotales, String name) {
        this.caloriasTotales = caloriasTotales;
        this.name = name;
    }
}
