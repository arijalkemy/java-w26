package com.meli;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase principal de la aplicación.
 */
public class Main
{
    /**
     * Método principal de la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main( String[] args )
    {
        // Crear un garaje con una lista de vehículos
        Garaje garaje = new Garaje(1, Stream.of(
                new Vehiculo("Ford","Fiesta",1000),
                new Vehiculo("Ford","Focus",1200),
                new Vehiculo("Ford","Explorer",2500),
                new Vehiculo("Fiat","Uno",500),
                new Vehiculo("Fiat","Cronos",1000),
                new Vehiculo("Fiat","Torino",1250),
                new Vehiculo("Chevrolet","Aveo",1250),
                new Vehiculo("Chevrolet","Spin",2500),
                new Vehiculo("Toyota","Corola",1200),
                new Vehiculo("Toyota","Fortuner",3000),
                new Vehiculo("Renault","Logan",950)
        ).collect(Collectors.toList()));

        // Obtener la lista de vehículos del garaje
        List<Vehiculo> listaDeVehiculos = garaje.getVehiculos();

        // Ordenar la lista de vehículos por costo
        listaDeVehiculos= listaDeVehiculos.stream()
                .sorted(Comparator.comparingInt((Vehiculo::getCosto)))
                .collect(Collectors.toList());

        // Imprimir la lista ordenada de vehículos
        ImprimirLista(listaDeVehiculos);
        System.out.println("------------------------");

        // Ordenar la lista de vehículos por marca
        List<Vehiculo> listaDeVehiculosMarcaPrecio = listaDeVehiculos;
        listaDeVehiculosMarcaPrecio = listaDeVehiculosMarcaPrecio.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toList());

        // Imprimir la lista ordenada de vehículos
        ImprimirLista(listaDeVehiculosMarcaPrecio);
        System.out.println("------------------------");

        // Filtrar la lista de vehículos para obtener aquellos con un costo menor o igual a 1000
        List<Vehiculo> listaMenorA = garaje.getVehiculos();
        listaMenorA = listaMenorA.stream()
                .filter(x-> x.getCosto()<=1000)
                .collect(Collectors.toList());

        // Imprimir la lista filtrada de vehículos
        System.out.println("Lista de Menores o iguales a 1000");
        ImprimirLista(listaMenorA);
        System.out.println("------------------------");

        // Filtrar la lista de vehículos para obtener aquellos con un costo mayor o igual a 1000
        List<Vehiculo> listaMayor = garaje.getVehiculos();
        listaMayor = listaMayor.stream()
                .filter(x->x.getCosto()>=1000)
                .collect(Collectors.toList());

        // Imprimir la lista filtrada de vehículos
        System.out.println("Lista de Mayores o iguales a 1000");
        ImprimirLista(listaMayor);
        System.out.println("----------------");


        // Ordenar la lista de vehículos por marca y luego por costo
        List<Vehiculo> listaMayor2 = garaje.getVehiculos();
        listaMayor2 = listaMayor2.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());


        // Imprimir la lista ordenada de vehículos
        System.out.println("------------- lista de vehiculos ordenados por marca y precio --------------");
        ImprimirLista(listaMayor2);
        System.out.println("------------------------");

        // Calcular el promedio de costo de los vehículos
        double promedio = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();
        System.out.println("Promedio: "+promedio);
    }
    /**
     * Método para imprimir una lista de vehículos.
     * @param listaDeVehiculos Lista de vehículos para imprimir.
     */
    public static void ImprimirLista (List<Vehiculo> listaDeVehiculos){
        for (Vehiculo vehiculo : listaDeVehiculos) {
            System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo()+" "+vehiculo.getCosto());
        }
    }
}