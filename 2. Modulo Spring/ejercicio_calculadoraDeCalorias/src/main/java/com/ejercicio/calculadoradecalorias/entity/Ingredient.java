package com.ejercicio.calculadoradecalorias.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Ingredient {
    private String name;
    private double calories;
}
