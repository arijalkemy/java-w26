package com.covid.covid.models.dto;

import java.io.Serializable;

public class PersonasRiesgoDTO implements Serializable {
    private String nombre;
    private String apellido;

    public PersonasRiesgoDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
