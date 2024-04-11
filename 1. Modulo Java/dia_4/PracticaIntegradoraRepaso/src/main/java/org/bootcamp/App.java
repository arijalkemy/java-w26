package org.bootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        List<Vehiculo> listaVehiculos = new ArrayList<>();
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
        Garaje garaje = new Garaje(1, listaVehiculos);
        System.out.println("\n Lista original de Vehiculos");
        garaje.mostrarVehiculos();
        System.out.println("\n Vehiculos ordenados por precio");
        garaje.ordernarPorPrecio();
        garaje.mostrarVehiculos();
        System.out.println("\n Vehiculos ordenados por marca y precio");
        garaje.ordernarVehiculosPorMarcaYPecio();
        garaje.mostrarVehiculos();
        System.out.println("\n Lista de vehiculos con precio no mayor a 1000");
        System.out.println(garaje.listaMenorAMil());
        System.out.println("\n Lista de vehiculos con precio mayor o igual a 1000");
        System.out.println(garaje.listaMayorOIgualAMil());
        System.out.println("\n Promedio de precios:");
        System.out.println(garaje.promedio());
    }
}
