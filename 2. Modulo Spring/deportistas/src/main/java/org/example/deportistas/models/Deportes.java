package org.example.deportistas.models;

public class Deportes {
    private String nombre;
    private String nivel;

    public Deportes(String nombre, String  nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Deportes() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
