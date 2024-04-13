package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje miGaraje = new Garaje(1, vehiculos);

        miGaraje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("======================================");
        miGaraje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("======================================");
        miGaraje.getVehiculos().stream().filter(n -> n.getCosto()<1000).forEach(System.out::println);
        System.out.println("======================================");
        miGaraje.getVehiculos().stream().filter(n -> n.getCosto()>1000).forEach(System.out::println);
        System.out.println("======================================");

        double totalCost = 0;
        for (Vehiculo vehiculo :
                miGaraje.getVehiculos()) {
            totalCost += vehiculo.getCosto();
        }
        System.out.println("Promedio de Costos: " + totalCost/miGaraje.getVehiculos().size());

    }
}
