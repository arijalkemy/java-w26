package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
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
        /*
        * Ordenamos por precio el
        * */
        List<Vehiculo> listaDeVehiculos = garaje.getVehiculos();
        listaDeVehiculos= listaDeVehiculos.stream()
                .sorted(Comparator.comparingInt((Vehiculo::getCosto)))
                .collect(Collectors.toList());
        ImprimirLista(listaDeVehiculos);
        System.out.println("------------------------");

        List<Vehiculo> listaDeVehiculosMarcaPrecio = garaje.getVehiculos();
        listaDeVehiculosMarcaPrecio = listaDeVehiculosMarcaPrecio.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparing(Vehiculo::getCosto)))
                .collect(Collectors.toList());
        ImprimirLista(listaDeVehiculosMarcaPrecio);
        System.out.println("------------------------");

        List<Vehiculo> listaMenorA = garaje.getVehiculos();
        listaMenorA = listaMenorA.stream()
                .filter(x-> x.getCosto()<=1000)
                .collect(Collectors.toList());
        System.out.println("Lista de Menores o iguales a 1000");
        ImprimirLista(listaMenorA);

        System.out.println("------------------------");

        List<Vehiculo> listaMayor = garaje.getVehiculos();
        listaMayor = listaMayor.stream()
                .filter(x->x.getCosto()>=1000)
                .collect(Collectors.toList());
        System.out.println("Lista de Mayores o iguales a 1000");
        ImprimirLista(listaMayor);
        System.out.println("----------------");

        double promedio = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();
        System.out.println("Promedio: "+promedio);
    }
    public static void ImprimirLista (List<Vehiculo> listaDeVehiculos){
        for (Vehiculo vehiculo : listaDeVehiculos) {
            System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo()+" "+vehiculo.getCosto());
        }
    }
}
