package org.example.socorrista;

import org.example.vehiculo.Moto;

public class SocorristaMoto {
    public void socorrer(Moto moto){
        System.out.println("Socorriendo moto con la patente: " + moto.getPatente());
    }
}
