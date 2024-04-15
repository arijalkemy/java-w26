package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Creacion de los socorristas
        SocorristaAuto socorristaAuto = new SocorristaAuto(120, 30, 20, 1);
        SocorristaMoto socorristaMoto = new SocorristaMoto(70, 15, 8, 2);
        // Creación de autos y motos y guardado e inscripción de los mismos
        List<Vehiculo> vehiculos = List.of(
            new Auto(100, 20, 10, 1),
            new Auto(120, 30, 20, 2),
            new Moto(50, 10, 5, 3),
            new Moto(70, 15, 8, 4));
        Carrera carrera = new Carrera(100000,"Carrera de 100KM", 10000, 10,vehiculos, socorristaMoto, socorristaAuto);
        // Agregar dos vehiculos mas
        carrera.darDeAltaVehiculo(110, 25, 15, 5);
        carrera.darDeAltaVehiculo(60, 12, 6, 6);
        // Mostrar los vehiculos inscriptos
        System.out.println("Vehiculos inscriptos:");
        carrera.mostrarParticipantes();
        // Eliminar un vehiculo
        carrera.eliminarVehiculo(carrera.buscarVehiculo(4));
        // Mostrar los vehiculos inscriptos
        System.out.println("Vehiculos inscriptos:");
        carrera.mostrarParticipantes();
        // Socorrer un auto
        carrera.getSocorristaMoto().socorrer(vehiculos.get(0));
        // Socorrer una moto
        carrera.getSocorristaAuto().socorrer(vehiculos.get(1));
        // Mostrar el ganador
        System.out.println("Carrera finalizada, el ganador es: " + carrera.getGanador().getPatente());
    }
}
