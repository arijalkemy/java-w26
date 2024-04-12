package org.example.clases;

import org.example.interfaces.ISocorrer;

public class SocorristaMoto implements ISocorrer<Moto> {

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto de patente " + vehiculo.getPatente());
    }
}
