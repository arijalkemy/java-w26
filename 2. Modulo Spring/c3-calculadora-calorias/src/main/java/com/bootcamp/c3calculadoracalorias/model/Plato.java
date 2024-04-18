package com.bootcamp.c3calculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plato {
    private String nombre;
    private int peso;
    private List<Ingrediente> ingredientes;
}
