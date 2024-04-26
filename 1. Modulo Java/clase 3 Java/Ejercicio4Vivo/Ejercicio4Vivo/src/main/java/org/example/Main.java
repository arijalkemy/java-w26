package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, vehiculos);
        garaje.ordenarVehiculosPorPrecio();
        garaje.getListaVehiculos().forEach(System.out::println);

        garaje.ordenarVehiculosPorNombreYPrecio();
        garaje.getListaVehiculos().forEach(System.out::println);
        System.out.println("------------------------------------");
        System.out.println("Los vehículos con un costo menor a mil son: ");
        garaje.obtenerVehiculosMenorAMil().forEach(System.out::println);
        System.out.println("------------------------------------");
        System.out.println("Los vehículos con un costo mayor o igual a mil son: ");
        garaje.obtenerVehiculosMayorAMil().forEach(System.out::println);
        System.out.println("------------------------------------");

        System.out.println("El promedio de costos de la sumatoria de los vehículos es de");
        System.out.println("$"+garaje.obtenerPromedioCostoVehiculo());

    }
}