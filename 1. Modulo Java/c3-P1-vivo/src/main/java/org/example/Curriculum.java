package org.example;

public class Curriculum implements Documento{
    Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }
    public String toString() {
        return "Curriculum: " +
                "persona=" + persona +
                '.';
    }
    public Persona getPersona() {
        return persona;
    }

    public Curriculum setPersona(Persona persona) {
        this.persona = persona;
        return this;
    }
}
