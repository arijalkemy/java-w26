package org.example.socorrista;

import org.example.vehiculo.Moto;
import org.example.vehiculo.Vehiculo;

public class SocorristaMoto {
    public void socorrerMoto(Moto moto){
        System.out.println("Socorriendo a la moto con patente: " + moto.getPantente().toString());
    }
}
