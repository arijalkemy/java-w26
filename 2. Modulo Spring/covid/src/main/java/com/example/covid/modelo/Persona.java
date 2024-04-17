package com.example.covid.modelo;

import lombok.Data;

import java.util.List;

@Data
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomaList;

    public Persona(int id, String nombre, String apellido, int edad, List<Sintoma> sintomaList) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomaList = sintomaList;
    }

}
