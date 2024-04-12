package org.example.Ejercicios_Integradores_P1.SINC.Dakar.Vehiculos;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class SocorristaMoto implements SocorrerMoto{

    public void socorristaMoto(Moto moto) {
        System.out.println("Socorriendo moto " + moto.getPatente());
    }
}
