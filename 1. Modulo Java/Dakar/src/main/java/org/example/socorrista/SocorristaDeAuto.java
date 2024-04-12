package org.example.socorrista;

import org.example.vehiculo.Auto;

public class SocorristaDeAuto implements iSocorrista<Auto>{
    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto " + vehiculo.getPatente());
    }
}
