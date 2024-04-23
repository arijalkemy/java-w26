package com.mercadolibre.Covid19API.model;

import java.util.List;

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> pSintomas;

    public Persona(String id, String nombre, String apellido, int edad, List<Sintoma> pSintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pSintomas = pSintomas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Sintoma> getpSintomas() {
        return pSintomas;
    }

    public void setpSintomas(List<Sintoma> pSintomas) {
        this.pSintomas = pSintomas;
    }
}
