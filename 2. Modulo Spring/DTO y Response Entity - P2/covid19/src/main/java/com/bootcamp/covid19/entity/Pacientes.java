package com.bootcamp.covid19.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pacientes {
    private List<Persona> personas;

    public Pacientes() {
        personas = new ArrayList<>(
                List.of(
                        new Persona(76567, "Juan", "Perez", 25),
                        new Persona(86578, "Maria", "Lopez", 65),
                        new Persona(18675, "Pedro", "Gomez", 40),
                        new Persona(87665, "Ana", "Diaz", 70),
                        new Persona(93421, "Luis", "Torres", 80)
                )
        );
    }
}
