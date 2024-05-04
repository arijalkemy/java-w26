package com.calculadora.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private int calories;

    @Override
    public String toString() {
        return "Ingrediente{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
