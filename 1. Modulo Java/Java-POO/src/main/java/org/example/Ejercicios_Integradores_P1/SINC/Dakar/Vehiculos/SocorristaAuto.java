package org.example.Ejercicios_Integradores_P1.SINC.Dakar.Vehiculos;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SocorristaAuto  implements SocorrerAuto{

    public void socorristaAuto(Auto auto) {
        System.out.println("Socorriendo auto " + auto.getPatente());
    }
}
