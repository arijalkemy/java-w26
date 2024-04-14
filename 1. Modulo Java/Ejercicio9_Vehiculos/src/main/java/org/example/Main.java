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
        vehiculos.add(new Vehiculo("Toyota", "Forner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje("Garaje123", vehiculos);
        ManejadorVehiculos manejadorVehiculos = garaje.getManejadorVehiculos();

        System.out.println("------------------------------");
        System.out.println("Vehículos por Precio");
        System.out.println("------------------------------");
        manejadorVehiculos.ordenarPorPrecio();
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println("Marca: " + vehiculo.getMarca() + " ----- Modelo: " + vehiculo.getModelo() + " ----- Costo: " + vehiculo.getCosto());
        }

        System.out.println("------------------------------");
        System.out.println("Vehículos por Marca y Precio");
        System.out.println("------------------------------");
        manejadorVehiculos.ordenarPorMarcaYPrecio();
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println("Marca: " + vehiculo.getMarca() + " ----- Modelo: " + vehiculo.getModelo() + " ----- Costo: " + vehiculo.getCosto());
        }

        System.out.println("------------------------------");
        System.out.println("Menores o iguales a 1000");
        System.out.println("------------------------------");
        for (Vehiculo vehiculo : manejadorVehiculos.getMenoresOIgual1000()) {
            System.out.println("Marca: " + vehiculo.getMarca() + " ----- Modelo: " + vehiculo.getModelo() + " ----- Costo: " + vehiculo.getCosto());
        }

        System.out.println("------------------------------");
        System.out.println("Mayores a 1000");
        System.out.println("------------------------------");
        for (Vehiculo vehiculo : manejadorVehiculos.getMayores1000()) {
            System.out.println("Marca: " + vehiculo.getMarca() + " ----- Modelo: " + vehiculo.getModelo() + " ----- Costo: " + vehiculo.getCosto());
        }

        System.out.println("------------------------------");
        System.out.println("Promedio");
        System.out.println("------------------------------");
        System.out.println(manejadorVehiculos.getPromedio());

    }
}