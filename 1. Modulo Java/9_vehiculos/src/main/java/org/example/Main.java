package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Item 2) -------------
        Garage garage = new Garage(0);
        garage.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garage.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garage.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.agregarVehiculo(new Vehiculo("Renault", "Logan", 950));

        // Item 3) -------------
        System.out.println("Lista de vehiculos ordenados por COSTO: ");
        for (Vehiculo vehiculo : garage.getVehiculosSortedByCosto()) {
            System.out.println(vehiculo);
        }
        System.out.println("------- \n");

        // Item 4) -------------
        System.out.println("Lista de vehiculos ordenados por Costo y Marca: ");
        for (Vehiculo vehiculo : garage.getVehiculosSortedByMarcaPrice()) {
            System.out.println(vehiculo);
        }
        System.out.println("------- \n");

        // Item 5) -------------
        List<Vehiculo> vehiculosBelowThousand = garage.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() < 1000)
                .toList();
        System.out.println("Lista de vehiculos con costo menor a  1000: ");
        for (Vehiculo vehiculo : vehiculosBelowThousand) {
            System.out.println(vehiculo);
        }
        System.out.println("------- \n");

        List<Vehiculo> vehiculosAboveThousand = garage.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();
        System.out.println("Lista de vehiculos con costo mayor a  1000: ");
        for (Vehiculo vehiculo : vehiculosAboveThousand) {
            System.out.println(vehiculo);
        }
        System.out.println("------- \n");

        System.out.println("Promedio de costo de TODOS los vehiculos: $ " + garage.getVehiculosPriceAVG() );

    }
}