package com.example.c2deportistas.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.StringBufferInputStream;

@Getter
@Setter
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private DeporteDTO deporteRealizado;

    public String getNombre() {
        return nombre;
    }

    public PersonaDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public PersonaDTO setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public DeporteDTO getDeporteRealizado() {
        return deporteRealizado;
    }

    public PersonaDTO setDeporteRealizado(DeporteDTO deporteRealizado) {
        this.deporteRealizado = deporteRealizado;
        return this;
    }
}
