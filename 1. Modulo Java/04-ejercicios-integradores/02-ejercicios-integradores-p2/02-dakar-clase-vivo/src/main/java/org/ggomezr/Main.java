package org.ggomezr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//      Crear vehiculos para la carrera
        Vehiculo auto = new Vehiculo(200, 10, 5, "ABC123", 1000, 4, "Auto");
        Vehiculo moto1 = new Vehiculo(180, 8, 6, "XYZ789", 300, 2, "Moto");
        Vehiculo moto2 = new Vehiculo(230, 9, 6, "XYZ123", 310, 2, "Moto");

//      Crear lista de vehiculos
        List<Vehiculo> vehiculos = new ArrayList<>();

//      Agregar los vehiculos a la lista
        vehiculos.add(auto);
        vehiculos.add(moto1);
        vehiculos.add(moto2);

//      Crear el socorrista
        Socorrista socorrista = new Socorrista("Joe", "Doe");

//      Crear la carrera
        Carrera carrera = new Carrera(1000, 5000, "Gran premio", 10, vehiculos, socorrista);

        System.out.println("\n------ Socorriendo a un vehiculo ------\n");

//      Socorrer un vehiculo
        carrera.getSocorrista().socorrer(auto);

        System.out.println("\n------ Eliminando un vehiculo de la carrera ------\n");

//      Eliminar un vehiculo de la carrera
        carrera.eliminarVehiculo(moto2);

        System.out.println("\n------ Ganador de la carrera ------\n");

//      Determinar el ganador de la carrera
        System.out.println("El ganador de la carrera " + carrera.getNombre() + " es:");
        carrera.determinarGanador().ifPresent(ganador -> System.out.println(ganador.getTipoVehiculo() + " con patente " + ganador.getPatente()));
    }
}