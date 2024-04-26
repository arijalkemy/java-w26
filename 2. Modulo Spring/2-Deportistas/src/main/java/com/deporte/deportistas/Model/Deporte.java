package com.deporte.deportistas.Model;

public class Deporte {

    private String nombre;

    private int nivel;

    public Deporte(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
