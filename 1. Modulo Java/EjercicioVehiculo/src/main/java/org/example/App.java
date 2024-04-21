package org.example;

import org.example.entity.Garage;
import org.example.entity.Vehiculo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta",1000));
        vehiculos.add(new Vehiculo("Ford", "Focus",1200));
        vehiculos.add(new Vehiculo("Ford", "Explores",2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno",500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo",1250));
        vehiculos.add(new Vehiculo("chevrolet", "Spin",2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola",1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner",3000));
        vehiculos.add(new Vehiculo("Renault", "Logan",950));

        Garage garage = new Garage(1, vehiculos);

        List<Vehiculo> vehiculosOrdenadosPorPrecio = new ArrayList<>();
        vehiculosOrdenadosPorPrecio=garage.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();
        System.out.println("----------------Lista de carros por precio----------------");
        for(Vehiculo v: vehiculosOrdenadosPorPrecio){
            System.out.println("Marca: "+v.getMarca()+" Modelo: "+v.getModelo()+" Precio: "+v.getCosto());
        }

        vehiculosOrdenadosPorPrecio=garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .toList();
        System.out.println("----------------Lista de carros por precio y por marca----------------");
        for(Vehiculo v: vehiculosOrdenadosPorPrecio){
            System.out.println("Marca: "+v.getMarca()+" Modelo: "+v.getModelo()+" Precio: "+v.getCosto());
        }

        vehiculosOrdenadosPorPrecio=garage.getVehiculos().stream()
                .filter(v->v.getCosto()<1000)
                .toList();
        System.out.println("----------------Lista de carros por precio menor 1000---------------");
        for(Vehiculo v: vehiculosOrdenadosPorPrecio){
            System.out.println("Marca: "+v.getMarca()+" Modelo: "+v.getModelo()+" Precio: "+v.getCosto());
        }

        vehiculosOrdenadosPorPrecio=garage.getVehiculos().stream()
                .filter(v->v.getCosto()>=1000)
                .toList();
        System.out.println("----------------Lista de carros por precio igual o mayor 1000---------------");
        for(Vehiculo v: vehiculosOrdenadosPorPrecio){
            System.out.println("Marca: "+v.getMarca()+" Modelo: "+v.getModelo()+" Precio: "+v.getCosto());
        }

        double promedio=0;
        for(Vehiculo vehiculo: garage.getVehiculos()){
            promedio+=vehiculo.getCosto();
        }
        System.out.println("El promedio total de los precios de toda la lista de vehiculos es:"+(promedio/garage.getVehiculos().size()));
    }
}
