package com.asinc_ejerciciocalculadoracalorias.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Plato {
    private String nombre;
    private double peso;
    private List<Ingrediente> listaIngredientes;
}
