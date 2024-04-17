package com.javabootcamp.apideportes.dto;

import lombok.Getter;
import lombok.Setter;

public class Persona {
    @Setter
    @Getter
    String nombre;
    @Getter
    @Setter
    String apellido;
    @Setter
    @Getter
    int edad;
    @Getter
    @Setter
    Deporte deportePracticado;

    public Persona(String nombre, String apellido, int edad, Deporte deportePracticado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportePracticado = deportePracticado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", deportePracticado=" + deportePracticado.toString() +
                '}';
    }
}
