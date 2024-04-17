package com.javabootcamp.covid19.dto;

import lombok.Data;

@Data
public class Persona {
    private int id;
    String nombre;
    String apellido;
    int edad;
    Sintoma sintoma;

    public Persona(int id, String nombre, String apellido, int edad, Sintoma sintoma) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintoma = sintoma;
    }
}
