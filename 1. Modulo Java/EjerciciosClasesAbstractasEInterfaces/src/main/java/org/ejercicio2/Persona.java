package org.ejercicio2;

import java.util.List;

public class Persona {
    private final String nombre;
    private final String apellido;


    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
            "nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            '}';
    }
}
