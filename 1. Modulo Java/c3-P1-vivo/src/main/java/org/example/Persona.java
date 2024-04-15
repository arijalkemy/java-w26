package org.example;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private List<String> habilidades;

    public Persona(String nombre, List<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>();
    }

   public String toString() {
        return "Persona: " +
                "nombre='" + nombre + '\'' +
                ", habilidades=" + habilidades +
                '.';
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public Persona setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
