package org.example;

public class Automovil {
    //Atributos
    private String marca;
    private String color;
    private double kilometros;

    public Automovil() {
    }

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;
    }
}
