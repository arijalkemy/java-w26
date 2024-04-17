package com.dtoEntityDeportistasParte2.parte2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private int nivel;

    public Deporte() {
    }

}
