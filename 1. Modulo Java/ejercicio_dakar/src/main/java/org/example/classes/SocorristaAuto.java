package org.example.classes;

public class SocorristaAuto extends Vehiculo{

    public SocorristaAuto(float velocidad, float aceleracion, float anguloDeGiro, String patente, float peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto: " + auto.getPatente());
    }
}
