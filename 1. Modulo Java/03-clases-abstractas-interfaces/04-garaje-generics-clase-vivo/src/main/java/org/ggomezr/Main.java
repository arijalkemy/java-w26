package org.ggomezr;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = Arrays.asList(
            new Vehiculo("Ford", "Fiesta", 1000),
            new Vehiculo("Ford", "Focus", 1200),
            new Vehiculo("Ford", "Explorer", 2500),
            new Vehiculo("Fiat", "Uno", 500),
            new Vehiculo("Fiat", "Cronos", 1000),
            new Vehiculo("Fiat", "Torino", 1250),
            new Vehiculo("Chevrolet", "Aveo", 1250),
            new Vehiculo("Chevrolet", "Spin", 2500),
            new Vehiculo("Toyota", "Corola", 1200),
            new Vehiculo("Toyota", "Fortuner", 3000),
            new Vehiculo("Renault", "Logan", 950)
        );

        Garaje garaje = new Garaje(vehiculos);

        System.out.println("\n----- Vehiculos ordenados por costo -----\n");
        garaje.ordenarPorCosto();

        System.out.println("\n----- Vehiculos ordenados por marca y costo -----\n");
        garaje.ordenarPorMarcaYCosto();

        System.out.println("\n----- Vehiculos con precio menor a 1000 -----\n");
        garaje.obtenerVehiculosCostoMenorA1000();

        System.out.println("\n----- Vehiculos con precio mayor o igual a 1000 -----\n");
        garaje.obtenerVehiculosCostoMayorA1000();

        System.out.println("\n----- Promedio total de precios de los vehiculos -----\n");
        garaje.obtenerPromedioPreciosVehiculos();

    }
}