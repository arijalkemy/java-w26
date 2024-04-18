package com.example.calorias.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private int calories;
    private int pesoEnGr;


    public Ingrediente(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public Ingrediente setPesoEnGr(int pesoEnGr) {
        return new Ingrediente(this.name,this.calories, pesoEnGr);
    }
}
