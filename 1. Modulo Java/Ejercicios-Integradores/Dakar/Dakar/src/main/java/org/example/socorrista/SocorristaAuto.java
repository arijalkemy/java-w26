package org.example.socorrista;

import org.example.vehiculo.Auto;
import org.example.vehiculo.Vehiculo;

public class SocorristaAuto {
    public void soccorrerAuto(Auto auto){
        System.out.println("Soccoriendo al auto con patente: " + auto.getPantente());
    }
}
