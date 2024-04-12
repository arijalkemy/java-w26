package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class App 
{
    public static void main( String[] args )
    {
        Vehiculo v1= new Vehiculo("Fiesta","Ford", 1000);
        Vehiculo v2= new Vehiculo("Focus","Chevrolet", 1200);
        Vehiculo v3= new Vehiculo("Fiesta","Toyota", 1000);
        Vehiculo v4= new Vehiculo("Fiesta","Fiat", 900);


        List<Vehiculo> listaVehiculos = Arrays.asList(v1,v2,v3, v4);
        Garaje garaje = new Garaje("3123das",listaVehiculos);

        List<Vehiculo> listaOrdenadaPorCosto = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();

        System.out.println("------ LISTA ORDENADA POR COSTO -------------");
        recorrerLista(listaOrdenadaPorCosto);

        System.out.println("-------------------");
        System.out.println("------ LISTA ORDENADA POR MARCA Y COSTO -------------");
        List<Vehiculo> listaOrdenadaPorMarcaYCosto = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .toList();

        recorrerLista(listaOrdenadaPorMarcaYCosto);

        System.out.println("-------------------");
        System.out.println("------ LISTA DE VEHICULOS CON COSTO MENOR A MIL -------------");
        List<Vehiculo> vehiculosPrecioMenorAMil = garaje.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();

        recorrerLista(vehiculosPrecioMenorAMil);

        System.out.println("-------------------");
        System.out.println("------ LISTA DE VEHICULOS CON COSTO MAYOR O IGUAL A MIL -------------");
        List<Vehiculo> vehiculosPrecioMayorAMil = garaje.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        recorrerLista(vehiculosPrecioMayorAMil);

        double promedioTotal = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average().orElse(0);

        System.out.println("-------------------");
        System.out.println("Promedio total de costos: " + promedioTotal);
    }

    private static void recorrerLista(List<Vehiculo> vehiculos){
        for (Vehiculo vehiculo: vehiculos){
            System.out.println(vehiculo.toString());
        }
    }
}

//Sala 4