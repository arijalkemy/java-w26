package org.example.socorrista;

import org.example.vehiculo.Auto;

public class SocorristaAuto {
    public void socorrer(Auto auto){
        System.out.println("Socorriendo auto con la patente: " + auto.getPatente());
    }
}
