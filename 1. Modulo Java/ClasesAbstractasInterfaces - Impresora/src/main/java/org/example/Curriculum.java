package org.example;

public class Curriculum implements IDocumento {
    private Persona persona;

    public Curriculum(Persona p) {
        this.persona = p;
    }

    public String getDatos() {
       return  persona.toString();
    }
}
