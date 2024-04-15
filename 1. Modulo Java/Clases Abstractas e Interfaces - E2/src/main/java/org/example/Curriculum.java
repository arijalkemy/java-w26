package org.example;

import java.util.Arrays;

public class Curriculum implements IImprimible {
    private String nombre;
    private String apellidos;
    private int edad;
    private String[] habilidades;

    public Curriculum(String nombre, String apellidos, int edad, String[] habilidades) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
