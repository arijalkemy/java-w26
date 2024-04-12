package org.ejerciciodos.entities;

import org.ejerciciodos.interfaces.IDocumento;

import java.util.List;

public class Curriculum implements IDocumento {

    Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        System.out.println("Persona: " + persona.toString());
    }
}
