package org.example._07covid19;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    @Setter
    private ArrayList<Sintoma> sintomas;

    public Persona(String id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

}
