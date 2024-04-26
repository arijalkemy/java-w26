package org.example.covid19.dto;

import java.io.Serializable;

public class PersonaDto implements Serializable {
    private String nombre;
    private String apellido;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido) {
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
