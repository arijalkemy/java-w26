package com.example.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
}
