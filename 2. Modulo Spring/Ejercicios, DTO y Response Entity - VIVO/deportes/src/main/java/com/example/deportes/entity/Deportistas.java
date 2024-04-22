package com.example.deportes.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Deportistas {
    private List<Persona> deportistas;

    public Deportistas() {
        deportistas = new ArrayList<>(List.of(
                new Persona("Juan", "Perez", 25),
                new Persona("Maria", "Gonzalez", 30),
                new Persona("Pedro", "Rodriguez", 22),
                new Persona("Ana", "Lopez", 28),
                new Persona("Luis", "Martinez", 35),
                new Persona("Sofia", "Garcia", 40),
                new Persona("Carlos", "Sanchez", 20),
                new Persona("Laura", "Fernandez", 18)
        ));
    }
}
