package com.dtoEntityDeportistasParte2.parte2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona() {
    }

}
