package org.example;

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
        List<Vehiculo> vehiculos = new ArrayList<>();
        cargarListaVehiculos(vehiculos);
        Garage garage = new Garage(1, vehiculos);

        // Con el metodo sort en la lista de vehiculos con expresiones lambda, obtener lista de vehiculos ordenados por precio de menor a mayor, imprime por pantalla el resultado
        System.out.println("----- Lista de vehiculos ordenados costo -----");
        garage.getVehiculosPorCosto().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        // Imprimir una lista ordenada por marca y a su vez precio
        System.out.println("----- Lista de vehiculos ordenados por marca y costo -----");
        garage.getVehiculosPorMarcaYCosto().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        // Extraer lista de vehiculos con precio no mayor a 1000, otra con mayor o igual a 1000 y obtener el promedio total de precios de toda la lista de vehiculos
        System.out.println("----- Lista de vehiculos con costo menor a mil -----");
        garage.getVehiculosSegunCostoMenorA(1000).forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("----- Lista de vehiculos con costo mayor o igual a mil -----");
        garage.getVehiculosSegunCostoMayorIgualA(1000).forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("----- El promedio total de costo de toda la lista de vehiculos es de: $" + garage.getPromedio() + " -----");
    }

    private static void cargarListaVehiculos(List<Vehiculo> listaVehiculos) {
        // Cargo la lista con los datos del ejercicio
        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listaVehiculos.add(new Vehiculo("Toyota", "Logan", 950));
    }
}
