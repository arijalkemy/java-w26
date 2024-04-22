package com.example.deportes.entity;

import lombok.Data;

import java.util.List;
@Data
public class Inscripcion {
    private Persona persona;
    private List<Deporte> deportes;

    public Inscripcion(Persona persona, List<Deporte> deporte) {
        this.persona = persona;
        this.deportes = deporte;
    }

}
