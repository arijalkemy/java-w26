package org.example._07covid19.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example._07covid19.Sintoma;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
public class PersonaConSintomasDTO implements Serializable {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<Sintoma> sintomas;

    public PersonaConSintomasDTO(String id, String nombre, String apellido, int edad, ArrayList<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public PersonaConSintomasDTO() {}

}
