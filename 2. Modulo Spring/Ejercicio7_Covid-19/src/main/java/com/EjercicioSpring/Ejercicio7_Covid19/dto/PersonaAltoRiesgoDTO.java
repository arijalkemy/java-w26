package com.EjercicioSpring.Ejercicio7_Covid19.dto;

import java.io.Serializable;

public class PersonaAltoRiesgoDTO implements Serializable {
    private String nombre;
    private String apellido;

    public PersonaAltoRiesgoDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
