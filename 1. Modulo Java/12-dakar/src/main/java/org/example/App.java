package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Vehiculo auto = new Auto(200, 180, 80, "AAA123");
        //Vehiculo moto = new Moto(220, 170, 90, "MMM234");

        Set<Vehiculo> lstVehiculos = new HashSet<>();
        //lstVehiculos.add(auto);
        //lstVehiculos.add(moto);

        Carrera carrera = new Carrera(100, lstVehiculos,4,"Carrera de prueba",10000);

        carrera.darDeAltaAuto(200, 180, 80, "AAA123");
        carrera.darDeAltaAuto(200, 180, 80, "AAA123");
        carrera.darDeAltaMoto(220, 170, 90, "MMM234");
        carrera.darDeAltaMoto(220, 170, 90, "MMN234");
        carrera.darDeAltaAuto(200, 180, 80, "AAB123");
        carrera.darDeAltaAuto(200, 180, 80, "ABB123");

        carrera.eliminarVehiculoConPatente("AAA123");
        carrera.eliminarVehiculoConPatente("ABBA123");

        Vehiculo vehiculoGanador = carrera.definirGanador();
        System.out.println("El vehiculo ganador es: " + vehiculoGanador);

        carrera.socorrerAuto("AAB123");
        carrera.socorrerAuto("ABBA123");
        carrera.socorrerMoto("MMN234");


    }
}
