package com.meli;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 500));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Corola", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Fiesta", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehiculos);

        garage.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getMonto));

        List<Vehiculo> vehiculosMenores1000 = new ArrayList<>();
        List<Vehiculo> vehiculosMayoresIgual1000 = new ArrayList<>();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMonto() <= 1000) {
                vehiculosMenores1000.add(vehiculo);
            } else {
                vehiculosMayoresIgual1000.add(vehiculo);
            }
        }

        System.out.println("Vehículos ordenados por precio (de menor a mayor):" + "\n");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getMonto() + " - " + vehiculo.getMarca());
        }

        vehiculos.sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getMonto)
        );

        System.out.println("Vehículos ordenados por marca y precio:" + "\n");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getMonto() + " - " + vehiculo.getMarca());
        }

        double sumaTotal = 0;
        for (Vehiculo vehiculo : vehiculos) {
            sumaTotal += vehiculo.getMonto();
        }
        double promedioTotal = sumaTotal / vehiculos.size();

        System.out.println("\nPromedio total de precios de todos los vehículos: " + promedioTotal);
    }
}
