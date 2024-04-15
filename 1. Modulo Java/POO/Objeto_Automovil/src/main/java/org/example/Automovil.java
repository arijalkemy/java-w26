package org.example;

public class Automovil {

    String marca;
    String color;
    int kilometros;

    //constructor
    public Automovil() {
    }

    public Automovil(String marca, String color, int kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;
    }

    public String mostrarKilometraje(){
        String kilometraje = "El kilometraje del vehiculo es: "+this.kilometros;
        return kilometraje;
    }
}