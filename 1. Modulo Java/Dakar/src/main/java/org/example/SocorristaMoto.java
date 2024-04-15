package org.example;

public class SocorristaMoto extends Auto{
    public SocorristaMoto(int velocidad, int aceleracion, int anguloDeGiro, int patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo moto patente " + vehiculo.getPatente());
    }
}
