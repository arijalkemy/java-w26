package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Garage {
    Integer id = 0;

    public Garage(Integer id) {
        this.id = id;
    }

    ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

    /**
    *Populates listaVehiculos given data
     */
    void populateData(String[][] data){
        for(String[] carro:data){
            this.listaVehiculos.add(new Vehiculo(carro[1], carro[0], Integer.parseInt(carro[2])));
        }
    }

    /**
     * Sorts and updates listaVehiculos by price
     */
    void sortByPrice(){
        System.out.println("Ordenados por precio");
        listaVehiculos = listaVehiculos.
                stream()
                .sorted((x,y)-> x.getCosto().compareTo(y.getCosto()))
                .collect(Collectors.toCollection(ArrayList::new));

        for(Vehiculo dato: listaVehiculos){
            System.out.println(dato);
        }
    }

    /**
     * Sorts listaVehiculos by name and price
     */
    void sortByName(){

        //Creamos comparator en el stream

        listaVehiculos = listaVehiculos.
                stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toCollection(ArrayList::new));

        //Impresión en pantalla
        System.out.println("Ordenados por nombre");
        listaVehiculos.forEach(System.out::println);
    }
    /**
     * Filters listaVehiculos by MAXRANGE
     */
    void costQueryMax(Integer range){
        ArrayList<Vehiculo> listaVehiculosQuery = new ArrayList<Vehiculo>(listaVehiculos);

        listaVehiculosQuery = listaVehiculosQuery.stream().
                filter(x -> x.getCosto() < range).
                collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Ordenados por rango");
        listaVehiculosQuery.forEach(System.out::println);

    }
    /**
     * Filters listaVehiculos by MINRANGE
     */
    void costQueryMin(Integer range){
        ArrayList<Vehiculo> listaVehiculosQuery = new ArrayList<Vehiculo>(listaVehiculos);

        listaVehiculosQuery = listaVehiculosQuery.stream().
                filter(x -> x.getCosto() >= range).
                collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Ordenados por rango");
        listaVehiculosQuery.forEach(System.out::println);
    }

    void sumVehiclesCost(){
        Double res = listaVehiculos.stream().mapToDouble(Vehiculo::getCosto).sum();
        System.out.printf("Precio total de vehículos es %.2f", res);
    }
}
