package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class App
{
    public static void main( String[] args )
    {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));


        Garaje garaje1 = new Garaje(1, vehiculos);


        System.out.println("ordenado por costo");
        garaje1.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        System.out.println("ordenado por costo y marca");
        garaje1.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        System.out.println("mayor a 1000");
        garaje1.getVehiculos()
                .stream()
                .filter((vehiculo) -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        System.out.println("menor a 1000");
        garaje1.getVehiculos()
                .stream()
                .filter((vehiculo) -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        System.out.println("promedio");
        double avg = garaje1.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
        System.out.println("Promedio : " + avg);

    }
}
