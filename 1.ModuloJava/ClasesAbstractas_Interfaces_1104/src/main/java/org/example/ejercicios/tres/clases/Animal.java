package org.example.ejercicios.tres.clases;

public abstract class Animal {
    private String nombre;
    private String Color;

    public void hacerRuido(){}


    public Animal(String nombre, String color) {
        this.nombre = nombre;
        Color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", Color='" + Color + '\'' +
                '}';
    }
}
