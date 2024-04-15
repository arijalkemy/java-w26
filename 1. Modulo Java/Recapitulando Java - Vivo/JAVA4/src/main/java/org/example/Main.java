package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 2
        Garaje garaje = new Garaje(
                1,
                new ArrayList<Vehiculo>(
                        Arrays.asList(
                                new Vehiculo("FORD", "Fiesta", 1000),
                                new Vehiculo("FORD", "Focus", 1200),
                                new Vehiculo("FORD", "Explorer", 2500),
                                new Vehiculo("FIAT", "Uno", 500),
                                new Vehiculo("FIAT", "Cronos", 1000),
                                new Vehiculo("FIAT", "Torino", 1250),
                                new Vehiculo("CHEVROLET", "Aveo", 1250),
                                new Vehiculo("CHEVROLET", "Spin", 2500),
                                new Vehiculo("TOYOYA", "Corona", 1250),
                                new Vehiculo("TOYOTA", "Fortuner", 3000),
                                new Vehiculo("Renault", "Logan", 500)
                        )
                )
        );

        // Ejercicio 3
        List<Vehiculo> sortedByCosto = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparingInt(vel -> vel.getCosto()))
                .toList();

        System.out.println();
        System.out.println("EJERCICIO 3 - SORTED BY COSTO");

        for(Vehiculo ve: sortedByCosto){
            String res = String.format("DATA: Modelo: %s - Marca: %s - Costo: %d", ve.getModelo(), ve.getMarca(), ve.getCosto());
            System.out.println(res);
        }

        // Ejercicio 4
        List<Vehiculo> sortedByMarcaYCosto = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .toList();

        System.out.println();
        System.out.println("EJERCICIO 4 - SORTED BY MARCA & COSTO");

        for(Vehiculo ve: sortedByMarcaYCosto){
            String res = String.format("DATA: Modelo: %s - Marca: %s - Costo: %d", ve.getModelo(), ve.getMarca(), ve.getCosto());
            System.out.println(res);
        }

        // Ejercicio 5 - A
        List<Vehiculo> sortedByCostoMenorAMil = garaje.getVehiculos().stream()
                                        .sorted(Comparator.comparingInt(ve -> ve.getCosto()))
                                        .filter(vel -> vel.getCosto() < 1000)
                                        .toList();

        System.out.println();
        System.out.println("EJERCICIO 5A - SORTED BY COSTO < 1000");

        for(Vehiculo ve: sortedByCostoMenorAMil){
            String res = String.format("DATA: Modelo: %s - Marca: %s - Costo: %d", ve.getModelo(), ve.getMarca(), ve.getCosto());
            System.out.println(res);
        }

        // Ejercicio 5 - B
        List<Vehiculo> sortedByCostoMayorAMil = garaje.getVehiculos().stream()
                .sorted((v1, v2) -> Integer.compare(v2.getCosto(), v1.getCosto()))
                .filter(vel -> vel.getCosto() >= 1000)
                .toList();

        System.out.println();
        System.out.println("EJERCICIO 5B - SORTED BY COSTO > 1000");
        for(Vehiculo ve: sortedByCostoMayorAMil){
            String res = String.format("DATA: Modelo: %s - Marca: %s - Costo: %d", ve.getModelo(), ve.getMarca(), ve.getCosto());
            System.out.println(res);
        }

        // Ejercicio 5 - C
        System.out.println();
        System.out.println("EJERCICIO 5C - AVERAGE OF COSTO");

        double Promedio = garaje.getVehiculos().stream().mapToDouble(ve -> ve.getCosto()).average().orElse(0.0d);
        System.out.println(String.format("Promedio del costo de Vehiculos: %f", Promedio));
    }
}