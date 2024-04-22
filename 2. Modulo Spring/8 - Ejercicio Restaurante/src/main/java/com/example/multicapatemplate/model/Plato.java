package com.example.multicapatemplate.model;

import lombok.Data;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Data
public class Plato {
    String nombre;
    HashMap<Ingrediente, Double> ingredientes = new HashMap<>();

    public Plato(String nombre) {
        this.nombre = nombre;
    }

    public void addIngrediente(Ingrediente ingrediente, double valor) {
        ingredientes.put(ingrediente, valor);
    }

    public double calcularCalorias(){
        return ingredientes.entrySet().stream().mapToDouble( e -> (e.getKey().getCalories() * e.getValue()) / 100 ).sum();
    }


    public Ingrediente getMAxCalorias(){
        return ingredientes.entrySet().stream().max((e,a) -> {
            double valueE = ( e.getKey().getCalories() * e.getValue() ) / 100;
            double valueA = ( a.getKey().getCalories() * a.getValue() ) / 100;
            return valueE > valueA ? 1 : -1;
        }).get().getKey();
    }
}
