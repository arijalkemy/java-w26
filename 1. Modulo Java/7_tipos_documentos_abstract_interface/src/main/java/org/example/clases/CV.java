package org.example.clases;

import java.util.List;

public class CV {

    private final Persona persona;
    private List<String> habilidades;

    public CV(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "CV{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }
}
