package com.meli.Covid19.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomasAsociados;

    public Persona(String id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona(String id, String nombre, String apellido, int edad, List<Sintoma> sintomasAsociados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomasAsociados = sintomasAsociados;
    }
}
