package com.meli;

import com.meli.Interfaces.ISafetyCar;

public class SocorristaMoto implements ISafetyCar<Moto> {

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto y este es su número de patente: " + moto.getPatente());
    }
}
