package org.example.classes;

public class SocorristaMoto extends Vehiculo {

    public SocorristaMoto(float velocidad, float aceleracion, float anguloDeGiro, String patente, float peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Moto moto) {
        System.out.println("Socorriendo auto: " + moto.getPatente());
    }
}
