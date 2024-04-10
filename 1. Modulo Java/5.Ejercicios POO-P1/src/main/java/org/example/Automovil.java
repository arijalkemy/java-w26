package org.example;

public class Automovil {

    String marca;
    String color;
    double kilometros;

    public Automovil() {

    }
    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        return "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
    }

    public static void main(String [] args){
        Automovil auto = new Automovil("Toyota", "Rojo", 32);
        System.out.println(auto.mostrarMarcaYColor());
    }
}




