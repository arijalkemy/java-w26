package com.meli;

import com.meli.Interfaces.ISafetyCar;

public class SocorristaAuto implements ISafetyCar<Auto> {

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto y este es su número de patente: " + auto.getPatente());
    }
}
