package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        // 2)
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
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

        Garage garage = new Garage(1, vehiculos);

        // 3)
        System.out.println("Vehiculos ordenados por precio de menor a mayor:");
        mostrarVehiculos(garage.ordenarVehiculosPorPrecioDeMenorAMayor());

        // 4)
        System.out.println("\nVehiculos ordenados por marca y precio:");
        mostrarVehiculos(garage.ordenarVehiculosPorMarcaYPrecio());

        // 5)
        System.out.println("\nVehiculos con precio no mayor a 1000:");
        mostrarVehiculos(garage.getVehiculosPrecioNoMayorAMil());
        System.out.println("\nVehiculos con precio mayor o igual a 1000:");
        mostrarVehiculos(garage.getVehiculosPrecioMayorOIgualAMil());
        System.out.println("\nPromedio de precios de vehiculos: $" + garage.getPromedioPreciosDeVehiculos());
    }

    public static void mostrarVehiculos(List<Vehiculo> vehiculos) {
        vehiculos.stream().forEach(System.out::println);
    }
}
