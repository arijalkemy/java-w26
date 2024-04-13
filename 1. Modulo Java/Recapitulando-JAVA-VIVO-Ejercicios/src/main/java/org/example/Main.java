package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo explorer = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo uno = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo cronos = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo torino = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo aveo = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo spin = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo corola = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo fortuner = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo logan = new Vehiculo("Logan", "Toyota", 950);

        Garage meliGarage = new Garage(1, Arrays.asList(fiesta, focus, explorer, uno, cronos, torino, aveo, spin, corola, fortuner, logan ));


        System.out.println("---filtrados por precio de menor a mayor");
        meliGarage.getListaDeVehiculos().stream()
                .sorted((vehiculoX, vehiculoY)-> vehiculoX.getCosto() - vehiculoY.getCosto())
                .forEach(System.out::println);

        System.out.println("\n---filtrados por marca y luego por precio de menor a mayor");
        meliGarage.getListaDeVehiculos().stream()
                .sorted((vehiculoX, vehiculoY)-> vehiculoX.getCosto() - vehiculoY.getCosto())
                .sorted((vehiculoX, vehiculoY)->vehiculoX.getMarca().compareToIgnoreCase(vehiculoY.getMarca()))
                .forEach(System.out::println);

        System.out.println("\n---menores a mil:");
        meliGarage.getListaDeVehiculos().stream()
                .filter((vehiculo )-> vehiculo.getCosto() <= 1000).forEach(System.out::println);
                //.toList();

        List<Vehiculo> listadoPrecioMayorAMil = meliGarage.getListaDeVehiculos().stream()
                .filter((vehiculo )-> vehiculo.getCosto() >= 1000)
                .toList();

        //System.out.println("\n---menores a mil:");
        //listadoPrecioMenorAMil.stream().forEach(System.out::println);
        System.out.println("\n---mayores a mil:");
        listadoPrecioMayorAMil.stream().forEach(System.out::println);

        System.out.println("\n---promedio de precios de toda la lista de vehiculos");
        double promedio = meliGarage.getListaDeVehiculos().stream()
                .mapToInt(vehiculo -> vehiculo.getCosto())
                .average().orElse(0.00);
        System.out.printf("%.2f%n",promedio);
    }
}
