package com.example.calorias.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private int nroTotalCalorias;

    public Plato(String nombre, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;

        nroTotalCalorias = ingredientes.stream().mapToInt(i -> i.getCalories()).sum();
    }
}
