package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garajeUno = new Garaje(1,listaVehiculos);

        // Se ordena la lista de vehiculos por costo y despues por marca
        listaVehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca));
        System.out.println("Printeando Vehiculos Ordernado Primero por precio y despues por marca");
        garajeUno.mostrarVehiculos();

        // Se ordena la lista de vehiculos solo por costo
        listaVehiculos.sort((x,y)->Double.compare((y.getCosto()),x.getCosto()));
        System.out.println("Printeando Vehiculos Ordernado por precio");
        garajeUno.mostrarVehiculos();

        //Se ordena la lista de vehiculos solo por marca

        listaVehiculos.sort((x,y)->x.getMarca().compareTo(y.getMarca()));
        System.out.println("Printeando Vehiculos Ordenados por marca");

        garajeUno.mostrarVehiculos();

        // Se filtra la lista de vehiculos menores a 1000 y se guarda en otra lista
        List<Vehiculo> listaVehiculoMenoresMil = listaVehiculos.stream().filter((x)->x.getCosto()<=1000).toList();
        Garaje garajeMenoresMil = new Garaje(2,listaVehiculoMenoresMil);

        System.out.println("Printeando Vehiculos Menores a Mil");
        garajeMenoresMil.mostrarVehiculos();


        // Se filtra la lista de vehiculos menores a 1000 y se guarda en otra lista
        List<Vehiculo> listaVehiculoMayoresMil = listaVehiculos.stream().filter((x)->x.getCosto()>1000).toList();
        Garaje garajeMayoresMil = new Garaje(2,listaVehiculoMayoresMil);

        System.out.println("Printeando Vehiculos Mayores a Mil");
        garajeMayoresMil.mostrarVehiculos();


        List<Vehiculo> vehiculosTest= listaVehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca)).toList();

        Garaje garajeDos = new Garaje(3,vehiculosTest);
        garajeDos.mostrarVehiculos();


    }
}
