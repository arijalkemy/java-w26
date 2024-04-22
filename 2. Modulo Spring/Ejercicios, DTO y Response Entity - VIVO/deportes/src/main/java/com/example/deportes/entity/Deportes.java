package com.example.deportes.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Deportes {
    private List<Deporte> deportes;

    public Deportes() {
        deportes= new ArrayList<>(List.of(
                new Deporte("Futbol", "Profesional"),
                new Deporte("Baloncesto", "Profesional"),
                new Deporte("Natacion", "Amateur"),
                new Deporte("Atletismo", "Recreativo"),
                new Deporte("Ciclismo", "Profesional"),
                new Deporte("Gimnasia", "Amateur"),
                new Deporte("Boxeo", "Profesional"),
                new Deporte("Tenis", "Profesional")));
    }
}
