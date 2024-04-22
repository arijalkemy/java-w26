package org.dakar.socorristas;

import org.dakar.vehiculos.Auto;

public class SocorristaAuto {

    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto de pantente " + auto.getPatente());
    }
}
