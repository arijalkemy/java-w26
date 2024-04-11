package org.example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Garaje garaje = new Garaje();
        garaje.addVehiculo(new Vehiculo(1000, "Ford", "Fiesta"));
        garaje.addVehiculo(new Vehiculo(1200, "Ford", "Focus"));
        garaje.addVehiculo(new Vehiculo(2500, "Ford", "Explorer"));
        garaje.addVehiculo(new Vehiculo(500, "Fiat", "Uno"));
        garaje.addVehiculo(new Vehiculo(1000, "Fiat", "Cronos"));
        garaje.addVehiculo(new Vehiculo(1250, "Fiat", "Torino"));
        garaje.addVehiculo(new Vehiculo(1250, "Chevrolet", "Aveo"));
        garaje.addVehiculo(new Vehiculo(2500, "Chevrolet", "Spin"));
        garaje.addVehiculo(new Vehiculo(2500, "Toyota", "Spin"));
        garaje.addVehiculo(new Vehiculo(3000, "Toyota", "Fortuner"));
        garaje.addVehiculo(new Vehiculo(950, "Renault", "Logan"));

        // -> Ordenar la lista anterior en base al costo de mayor a menor
        List<Vehiculo> a = garaje.getVehiculos().stream()
                .sorted((v1, v2) -> Integer.compare(v1.getCosto(), v2.getCosto()))
                .collect(Collectors.toList());

        // -> Imprimir la lista de vehiculos ordenados obtenida anteriormente
        for (Vehiculo vehiculosOrdenado : a) {
            System.out.println("Marca: " + vehiculosOrdenado.getMarca()+  "Modelo: " + vehiculosOrdenado.getModelo() + "Precio: " + vehiculosOrdenado.getCosto() );
        }

        // -> Imprimir una lista ordenada por Marca y por Precio
        List <Vehiculo>  vehiclesOrderedByMarca = garaje.getVehiculos().stream()
                .sorted((v1, v2)-> v1.getModelo().compareTo(v2.getModelo())).toList();
        System.out.println("___________________ORDENANDO POR MARCA___________________");
        // -> Imprimir la lista de vehiculos ordenados obtenida anteriormente
        for (Vehiculo vehiculosOrdenado : vehiclesOrderedByMarca) {
            System.out.println("Marca: " + vehiculosOrdenado.getMarca()+  "Modelo: " + vehiculosOrdenado.getModelo() + "Precio: " + vehiculosOrdenado.getCosto() );
        }

        List<Vehiculo> menoresA1000 = garaje.getVehiculos().stream().filter((e)-> e.getCosto() < 1000).collect(Collectors.toList());
        System.out.println("___________________IMPRIMIENDO LOS MENORES A 1000 ___________________");

        // -> Imprimir la lista de vehiculos ordenados obtenida anteriormente
        for (Vehiculo vehiculosOrdenado : menoresA1000) {
            System.out.println("Marca: " + vehiculosOrdenado.getMarca()+  "Modelo: " + vehiculosOrdenado.getModelo() + "Precio: " + vehiculosOrdenado.getCosto() );
        }

        List<Vehiculo> mayoresOIgualesA100 = garaje.getVehiculos().stream().filter((e)-> e.getCosto() >= 1000).collect(Collectors.toList());
        System.out.println("___________________IMPRIMIENDO LOS MQYORES O IGUALES A 1000 ___________________");

        // -> Imprimir la lista de vehiculos ordenados obtenida anteriormente
        for (Vehiculo vehiculosOrdenado : mayoresOIgualesA100) {
            System.out.println("Marca: " + vehiculosOrdenado.getMarca()+  "Modelo: " + vehiculosOrdenado.getModelo() + "Precio: " + vehiculosOrdenado.getCosto() );
        }

        Integer average  = garaje.getVehiculos().stream().map((e)-> e.getCosto()).reduce(Integer::sum).orElse(0);
        System.out.print("Average : " + average);
    }
}
