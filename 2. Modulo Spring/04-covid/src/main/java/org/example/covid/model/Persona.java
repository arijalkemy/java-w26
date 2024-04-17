package org.example.covid.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;

    public Persona(String id, String nombre, String apellido, int edad, List<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

}
