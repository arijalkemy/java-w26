package org.example;

import socorristas.Socorrista;

import javax.management.BadAttributeValueExpException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Vehiculo vehiculo1 = new Vehiculo(VehicleType.AUTO, 120, 30, 15, "123", 4);
        Vehiculo vehiculo2 = new Vehiculo(VehicleType.AUTO, 110, 35, 14, "124", 4);
        Vehiculo vehiculo3 = new Vehiculo(VehicleType.AUTO, 115, 32, 16, "125", 4);
        Vehiculo vehiculo4 = new Vehiculo(VehicleType.AUTO, 125, 28, 17, "126", 4);
        Vehiculo vehiculo5 = new Vehiculo(VehicleType.AUTO, 105, 40, 13, "127", 4);
        Vehiculo vehiculo6 = new Vehiculo(VehicleType.AUTO, 130, 25, 18, "128", 4);
        Vehiculo vehiculo7 = new Vehiculo(VehicleType.AUTO, 100, 45, 12, "129", 4);
        Vehiculo vehiculo8 = new Vehiculo(VehicleType.MOTO, 135, 20, 19, "130", 4);
        Vehiculo vehiculo9 = new Vehiculo(VehicleType.AUTO, 95, 50, 11, "131", 4);
        Vehiculo vehiculo10 = new Vehiculo(VehicleType.MOTO, 140, 15, 20, "132", 4);

        Socorrista socorrista = new Socorrista();

        Carrera carrera1 = new Carrera(
                12.0,
                1200.0,
                "Carrera 1",
                10
                );

        carrera1.darDeAltaVehiculo(vehiculo1);
        carrera1.darDeAltaVehiculo(vehiculo2);
        carrera1.darDeAltaVehiculo(vehiculo3);
        carrera1.darDeAltaVehiculo(vehiculo4);
        carrera1.darDeAltaVehiculo(vehiculo5);
        carrera1.darDeAltaVehiculo(vehiculo6);
        carrera1.darDeAltaVehiculo(vehiculo7);
        carrera1.darDeAltaVehiculo(vehiculo8);
        carrera1.darDeAltaVehiculo(vehiculo9);
        carrera1.darDeAltaVehiculo(vehiculo10);

        carrera1.obtenerRecordsCarrera();

        System.out.println("El ganador es: " +  carrera1.ganadorCarrera());


        socorrista.socorrer(vehiculo1);
        socorrista.socorrer(vehiculo8);





    }
}
