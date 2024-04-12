package org.example.socorrista;

import org.example.vehiculo.Moto;

public class SocorristaDeMoto implements iSocorrista<Moto>{
    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto " + vehiculo.getPatente());
    }
}
