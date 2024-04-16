package org.example.socorristas;

import org.example.vehiculos.Auto;

public class SocorristaAuto {

    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto de pantente " + auto.getPatente());
    }
}
