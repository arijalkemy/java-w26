package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Carrera carrera = new Carrera(42.5, 5, "Dakar1", 2);
        carrera.darDeAltaAuto(5, 10, 90, "HHM555");
        carrera.darDeAltaMoto(3, 20, 50, "AFS654");
        carrera.socorrerAuto("HHM555");
        carrera.socorrerAuto("asdfsdf");
        System.out.println(carrera.ganador());
        carrera.eliminarVehiculoConPatente("AFS654");
    }
}
