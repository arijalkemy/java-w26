package org.example;

import org.example.vehiculos.Auto;
import org.example.vehiculos.Moto;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Carrera carrera = new Carrera(5);
        Auto auto = carrera.darDeAltaAuto(
                200,
                100,
                60,
                "AAA111"
        );
        Moto moto = carrera.darDeAltaMoto(
                150,
                80,
                90,
                "Mot111"
        );

        carrera.socorrerAuto(auto.getPatente());
        carrera.socorrerMoto(moto.getPatente());

        System.out.println(carrera.vehiculoGanador().getPatente());

    }
}
