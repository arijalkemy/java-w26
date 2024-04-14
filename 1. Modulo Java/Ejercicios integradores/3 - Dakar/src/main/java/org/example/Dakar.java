package org.example;

/**
 * Hello world!
 *
 */
public class Dakar
{
    public static <Vehiculo> void main(String[] args) {
        // Crear una carrera
        Carrera dakar = new Carrera(5000, 1000000, "Dakar", 10);

        // Dar de alta algunos autos y motos
        dakar.darDeAltaAuto(200, 10, 5, "ABC123");
        dakar.darDeAltaMoto(180, 12, 3, "XYZ789");
        dakar.darDeAltaAuto(190, 11, 4, "DEF456");
        dakar.darDeAltaMoto(175, 14, 2, "UVW345");

        // Eliminar un vehículo por patente
        dakar.eliminarVehiculoConPatente("XYZ789");

        // Calcular y mostrar el ganador de la carrera
        org.example.Vehiculo ganador = dakar.calcularGanador();
        System.out.println("El ganador es el vehículo con patente " + ganador.patente);

        // Socorrer un auto específico
        dakar.socorrerAuto("ABC123");

        // Socorrer una moto específica
        dakar.socorrerMoto("UVW345");
    }}
