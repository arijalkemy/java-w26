package org.example;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = getGaraje();

        // Sobre el stream, sort no AFECTA permanentemente la lista
        // Sobre la lista directa, sort si la modifica

        System.out.println("------Ordeno por precio------");
        garaje.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        garaje.getVehiculos().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");

        System.out.println("------Ordeno por modelo------");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getModelo));
        garaje.getVehiculos().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");

        System.out.println("------Ordeno por marca y precio------");
        garaje.getVehiculos().sort(
                Comparator.comparing(Vehiculo::getModelo)
                .thenComparingDouble(Vehiculo::getCosto));

        garaje.getVehiculos().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");

        System.out.println("-----Vehiculos con precio < 1000-----");
        List<Vehiculo> vehiculos = garaje.getVehiculos().stream().filter(
                vehiculoP -> vehiculoP.getCosto() < 1000)
                .toList();

        vehiculos.forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");
        System.out.println("-----Vehiculos con precio >= 1000-----");
        // Mutable si al final cambio .tiList() por .collect(Collectors.toList())
        // Inmutable - Luego no te permite hacer set, add o cualquier metodo para modificar la lista
        vehiculos = garaje.getVehiculos().stream().filter(vehiculoP -> vehiculoP.getCosto() >= 1000).toList();
        vehiculos.forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");
        System.out.println("-----Promedio de todos los vehiculos-----");
        //OptionalDouble total = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();
        double defaultValue = 0.0;
        double total = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(defaultValue);

        System.out.println("El costo promedio de todos los vehiculos es: " + String.format("%.2f",total));
    }

    private static Garaje getGaraje() {
        Vehiculo vehiculo = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        Garaje garaje = new Garaje();
        garaje.addVehiculo(vehiculo);
        garaje.addVehiculo(vehiculo2);
        garaje.addVehiculo(vehiculo3);
        garaje.addVehiculo(vehiculo4);
        garaje.addVehiculo(vehiculo5);
        garaje.addVehiculo(vehiculo6);
        garaje.addVehiculo(vehiculo7);
        garaje.addVehiculo(vehiculo8);
        garaje.addVehiculo(vehiculo9);
        garaje.addVehiculo(vehiculo10);
        garaje.addVehiculo(vehiculo11);
        return garaje;
    }
}