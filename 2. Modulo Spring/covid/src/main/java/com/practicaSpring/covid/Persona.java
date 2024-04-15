package com.practicaSpring.covid;

import java.util.HashSet;
import java.util.Set;

public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private Set<Sintoma> sintomas;

    public Persona(Long id, String nombre, String apellido, int edad, Set<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Set<Sintoma> getSintomas() {
        return sintomas;
    }
}
