package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //Ejercicio 1
        //hacer las clases
        //Ejercicio 2
        Garaje garaje = new Garaje();

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        Vehiculo vehiculo = new Vehiculo("ford", "fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("ford", "focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("ford", "ka", 800);
        Vehiculo vehiculo4 = new Vehiculo("fiat", "modelo1", 500);
        Vehiculo vehiculo5 = new Vehiculo("fiat", "cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("fiat", "torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("chevrolet", "aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("chevrolet", "spin", 1500);
        Vehiculo vehiculo9 = new Vehiculo("toyota", "corolla", 1200);
        Vehiculo vehiculo10 = new Vehiculo("toyota", "fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("renault", "logan", 950);


        //Ejercicio 3
        vehiculos.add(vehiculo);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        garaje.setVehiculos(vehiculos);

        List<Vehiculo> listaOrdenadaPorPrecio = vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getCosto)).collect(Collectors.toList());
        System.out.println("Lista ordenada por precio");
        listaOrdenadaPorPrecio.forEach(v -> System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getCosto()));
        //Ejercicio 4
        System.out.println("Lista ordenada por marca");
        List<Vehiculo> listaOrdenadaPormarca = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).collect(Collectors.toList());

        listaOrdenadaPormarca.forEach(v -> System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getCosto()));

        //Ejercicio 5
        List<Vehiculo> listaMenorA1000 = vehiculos.stream().filter(a -> a.getCosto() < 1000).collect(Collectors.toList());
        List<Vehiculo> listaMayorA1000 = vehiculos.stream().filter(a -> a.getCosto() >= 1000).collect(Collectors.toList());

        double promedio = vehiculos.stream().mapToInt(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("Lista de vehiculos con costo menor a 1000 y mayor a 1000");
        listaMayorA1000.forEach(v -> System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getCosto()));
        System.out.println("Vehiculos con costo menor a 1000");
        listaMenorA1000.forEach(v -> System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getCosto()));

        System.out.println("Promedio: " + promedio);

    }

}