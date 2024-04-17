package org.example.covid.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    List<Sintoma> sintomas = new ArrayList<>();

    public Persona(int id, String nombre, String apellido, int edad, List<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public int getEdad() {
        return edad;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
