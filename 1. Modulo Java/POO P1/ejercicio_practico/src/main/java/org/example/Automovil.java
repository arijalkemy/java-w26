package org.example;

public class Automovil {

    private String marca;
    private String color;
    private int kilometros;

    public Automovil() {

    }

    public Automovil(String marca, String color, int kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        return  "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
    }
}