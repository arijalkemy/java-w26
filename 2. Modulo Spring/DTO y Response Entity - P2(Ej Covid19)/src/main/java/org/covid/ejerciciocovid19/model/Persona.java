package org.covid.ejerciciocovid19.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas = new ArrayList<>();

    public Persona(Long id, String apellido, String nombre, int edad, List<Sintoma> sintomas) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.sintomas = sintomas;
    }

}
