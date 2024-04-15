package org.example;

import org.example.Clases.Garaje;
import org.example.Clases.Vehiculo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Vehiculo> auto = new ArrayList<>();
        auto.add(new Vehiculo("Ford", "Fiesta", 1000));
        auto.add(new Vehiculo("Ford", "Focus", 1200));
        auto.add(new Vehiculo("Ford", "Explorer", 2500));
        auto.add(new Vehiculo("Fiat", "Uno", 500));
        auto.add(new Vehiculo("Fiat", "Cronos", 1000));
        auto.add(new Vehiculo("Fiat", "Torino", 1250));
        auto.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        auto.add(new Vehiculo("Chevrolet", "Spin", 2500));
        auto.add(new Vehiculo("Toyota", "Corola", 1200));
        auto.add(new Vehiculo("Toyota", "Fortuner", 3000));
        auto.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje= new Garaje(123, auto);

        /*Ejercicio 3
        garaje.getListaVehiculos().sort(Comparator.comparingInt(Vehiculo::getCosto));
        for (Vehiculo vehiculo : garaje.getListaVehiculos()) {
            System.out.println("Marca: "+vehiculo.getMarca()+",Modelo: "+vehiculo.getModelo()+", Costo: "+vehiculo.getCosto());
        }*/

        /*Ejercicio 4
        garaje.getListaVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        for (Vehiculo vehiculo : garaje.getListaVehiculos()) {
            System.out.println("Marca: "+vehiculo.getMarca()+",Modelo: "+vehiculo.getModelo()+", Costo: "+vehiculo.getCosto());
        }*/
        /*Ejercicio 5
        ArrayList<Vehiculo> menorMil = (ArrayList<Vehiculo>) garaje.getListaVehiculos()
                .stream()
                .filter(element -> element.getCosto() <1000)
                .collect(Collectors.toList());

        for (Vehiculo vehiculo : menorMil) {
            System.out.println("Marca: "+vehiculo.getMarca()+",Modelo: "+vehiculo.getModelo()+", Costo: "+vehiculo.getCosto());
        }

        ArrayList<Vehiculo> mayorMil = (ArrayList<Vehiculo>) garaje.getListaVehiculos()
                .stream()
                .filter(element -> element.getCosto() >=1000)
                .collect(Collectors.toList());

        for (Vehiculo vehiculo : mayorMil) {
            System.out.println("Marca: "+vehiculo.getMarca()+",Modelo: "+vehiculo.getModelo()+", Costo: "+vehiculo.getCosto());
        }

        double promedio = garaje.getListaVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
        System.out.println("Promedio: "+promedio);
        */

    }
}
