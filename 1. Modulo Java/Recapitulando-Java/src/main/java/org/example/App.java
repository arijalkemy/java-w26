package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Vehiculo fiesta = new Vehiculo("fiesta", "ford", 1000.0);
        Vehiculo focus = new Vehiculo("focus", "ford", 1200.0);
        Vehiculo explorer = new Vehiculo("explorer", "ford", 2500.0);
        Vehiculo uno = new Vehiculo("uno", "ford", 500.0);
        Vehiculo cronos = new Vehiculo("cronos", "ford", 1000.0);
        Vehiculo torino = new Vehiculo("torino", "ford", 1250.0);
        Vehiculo aveo = new Vehiculo("aveo", "ford", 1250.0);
        Vehiculo spin = new Vehiculo("spin", "ford", 2500.0);
        Vehiculo corola = new Vehiculo("corola", "ford", 1200.0);
        Vehiculo fortuner = new Vehiculo("fortuner", "ford", 3000.0);
        Vehiculo logan = new Vehiculo("logan", "ford", 950.0);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(fiesta);
        vehiculos.add(focus);
        vehiculos.add(explorer);
        vehiculos.add(uno);
        vehiculos.add(cronos);
        vehiculos.add(torino);
        vehiculos.add(aveo);
        vehiculos.add(spin);
        vehiculos.add(corola);
        vehiculos.add(fortuner);
        vehiculos.add(logan);

        Garaje garaje = new Garaje("1", vehiculos);

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
