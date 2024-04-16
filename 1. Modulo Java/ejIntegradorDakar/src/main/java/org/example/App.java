package org.example;

import org.example.model.*;

import java.util.Optional;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Carrera carrera = new Carrera(1.5, 200.0, "la gran velocia", 5);

        carrera.darDeAltaVehiculo(new Autos("dosh", 2.5, 2.7, 50.0));
        carrera.darDeAltaVehiculo(new Autos("for", 11.5, 2.7, 100.0));
        //Instanziation of two helpers
        carrera.darDeAltaVehiculo(new SocorristaAuto(new Autos("nisan", 10.5, 2.7, 100.0)));
        carrera.darDeAltaVehiculo(new SocorristaAuto(new Motos("yam aja", 10.5, 2.7, 100.0)));
        carrera.darDeAltaVehiculo(new Motos("apache", 10.5, 2.7, 100.0));


        carrera.sendSocorrist();


        System.out.println(carrera.winner());
    }
}
