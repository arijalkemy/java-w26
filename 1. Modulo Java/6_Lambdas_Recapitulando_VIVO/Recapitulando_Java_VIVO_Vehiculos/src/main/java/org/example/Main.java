package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Toyota", "Logan", 950));

        Garaje garaje = new Garaje(810937,vehiculos);
        System.out.println("=================Vehiculos ordenados=================\n");
        List<Vehiculo> vehiculosOrdenadosCosto = vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio))
                .toList();
        vehiculosOrdenadosCosto.forEach(System.out::println);
        System.out.println("=================Vehiculos ordenados por marca y precio=================\n");
        List<Vehiculo> vehiculosDobleCondicion = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing((Vehiculo::getPrecio))).toList();

        vehiculosDobleCondicion.forEach(System.out::println);

        System.out.println("=================Vehiculos con precio menor a 1000=================\n");
        List<Vehiculo> vehiculosConPreciosMenoresA1000= vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() < 1000)
                .toList();
        vehiculosConPreciosMenoresA1000.forEach(System.out::println);

        System.out.println("=================Vehiculos con precio Mayor o igual a 1000=================\n");
        List<Vehiculo> vehiculosConPreciosMayoresA1000= vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .toList();
        vehiculosConPreciosMayoresA1000.forEach(System.out::println);

        double promedio;
        promedio = vehiculos.stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average().getAsDouble();

        System.out.println("El promedio de precios es: " + promedio);
    }
}