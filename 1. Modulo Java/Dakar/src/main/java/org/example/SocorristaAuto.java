package org.example;

public class SocorristaAuto extends Auto{
    public SocorristaAuto(int velocidad, int aceleracion, int anguloDeGiro, int patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo auto patente " + vehiculo.getPatente());
    }
}
