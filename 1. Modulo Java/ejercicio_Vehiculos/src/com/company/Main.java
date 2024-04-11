package com.company;

import com.company.classes.Garaje;
import com.company.classes.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Se instancian los vehiculos y se añaden a la lista
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford", 1000);
        Vehiculo vehiculo2= new Vehiculo("Focus","Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer","Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno","Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos","Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino","Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo","Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin","Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola","Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner","Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan","Renault", 950);

        vehiculos.add(vehiculo1);
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

        // Se instancia el garaje
        Garaje garaje = new Garaje(0, vehiculos);

        // Vehiculos ordenados por precio
        List<Vehiculo> ordenadosPorPrecio = garaje.ordenarPorPrecio();

        // Vehiculos ordenados por marca y precio
        List<Vehiculo> ordenadosPorMarcaYPrecio = garaje.ordenarPorMarcaYPrecio();

        // Vehiculos con precio menor a 1000
        List<Vehiculo> menorA1000 = garaje.menorA1000();

        // Vehiculos con precio mayor o igual a 1000
        List<Vehiculo> mayorIgualA1000 = garaje.mayorIgualA1000();

        // Promedio total de toda la lista de precios
        double promedioPrecios = garaje.promedioPrecios();

        // Mostrar resultados en consola
        System.out.println("----------------------- Vehiculos ordenados por precio -----------------------");
        for(Vehiculo vehiculo : ordenadosPorPrecio) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("\n------------------- Vehiculos ordenados por marca y precio -------------------");
        for(Vehiculo vehiculo : ordenadosPorMarcaYPrecio) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("\n--------------------- Vehiculos con precio menor a 1000 ----------------------");
        for(Vehiculo vehiculo : menorA1000) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("\n----------------- Vehiculos con precio mayor o igual a 1000 ------------------");
        for(Vehiculo vehiculo : mayorIgualA1000) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("\nPromedio total de toda la lista de precios: $" + promedioPrecios);
    }
}
