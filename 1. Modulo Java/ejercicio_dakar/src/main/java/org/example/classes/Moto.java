package org.example.classes;

public class Moto extends Vehiculo{
    public Moto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }

    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto: " + moto.getPatente());
    }
}
