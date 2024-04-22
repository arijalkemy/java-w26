package com.example.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
@Data
public class Plato {

    private String nombre;
    private List<Ingrediente> ingredientes;
    private Integer calorias;

    public Plato(String nombre,List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.calorias = ingredientes.stream().mapToInt(Ingrediente::getCalorias).sum();
    }

    public Ingrediente maxCalorias(){
        return ingredientes.stream().max(Comparator.comparing(Ingrediente::getCalorias)).get();
    }
}
