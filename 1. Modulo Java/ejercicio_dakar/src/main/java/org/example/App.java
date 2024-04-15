package org.example;

import org.example.classes.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SocorristaAuto socorristaAuto = new SocorristaAuto(70, 12,90, "ANC123", 100, 4);
        SocorristaMoto socorristaMoto = new SocorristaMoto(70, 12,90, "AVC123", 100, 2);
        Carrera carrera = new Carrera(10000, 4500, "Carrera de autos", 10, socorristaAuto, socorristaMoto);

        carrera.darDeAltaAuto(145, 17, 180, "BMF430");
        carrera.darDeAltaAuto(148, 15, 180, "BMF479");
        carrera.darDeAltaAuto(175, 20, 180, "MMJ730");
        carrera.darDeAltaAuto(156, 24, 180, "BHF630");
        carrera.darDeAltaAuto(156, 24, 180, "BHF765");

        System.out.println(" - Se elimina un vehiculo con patente:");
        carrera.eliminarVehiculoConPatente("BHF765");

        System.out.println("\n - Se socorre un auto:");
        carrera.socorrerAuto("BHF630");

        System.out.println("\n - Ganador de la carrera: ");
        Vehiculo ganador = carrera.ganador();
        if (ganador != null) System.out.println("El ganador es el vehículo con patente " + ganador.getPatente());
        else System.out.println("No se pudo obtener el ganador de la carrera.");
    }
}
