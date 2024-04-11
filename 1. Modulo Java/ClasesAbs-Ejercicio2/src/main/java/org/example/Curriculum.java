package org.example;

import java.util.List;

public class Curriculum implements IImprimir{
    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum...");
        System.out.println(toString());
    }
}

class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}