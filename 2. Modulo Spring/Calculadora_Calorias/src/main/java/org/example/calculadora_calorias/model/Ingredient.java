package org.example.calculadora_calorias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Ingredient {
    private String name;
    private int calories;
}
