package org.example;

import org.example.Clases.Vehiculo;

import java.util.*;

import org.example.Clases.Garaje;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        Vehiculo fiesta = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo focus = new Vehiculo("Focus","Ford",1200);
        Vehiculo explorer = new Vehiculo("Explorer","Ford",2500);
        Vehiculo uno = new Vehiculo("Uno","Fiat",500);
        Vehiculo cronos = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo torino = new Vehiculo("Torino","Fiat",1250);
        Vehiculo aveo = new Vehiculo("Aveo","Chevrolet",1250);
        Vehiculo spin = new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo corolla = new Vehiculo("Corolla","Toyota",1200);
        Vehiculo fortuner = new Vehiculo("Fortuner","Toyora",3000);
        Vehiculo logan = new Vehiculo("Logan","Renault",950);


        List<Vehiculo> listaVehiculos = new ArrayList();
        listaVehiculos.add(fiesta);
        listaVehiculos.add(focus);
        listaVehiculos.add(explorer);
        listaVehiculos.add(uno);
        listaVehiculos.add(cronos);
        listaVehiculos.add(torino);
        listaVehiculos.add(aveo);
        listaVehiculos.add(spin);
        listaVehiculos.add(corolla);
        listaVehiculos.add(fortuner);
        listaVehiculos.add(logan);





        Garaje garaje = new Garaje(1,listaVehiculos);

        System.out.println("******************** Lista de autos ordenada por precio*****************************");

        List<Vehiculo> listSortedByPrice = garaje.getListaVehiculos().stream().sorted( Comparator.comparing(Vehiculo::getCosto)).toList();
        System.out.println(listSortedByPrice.toString());

        System.out.println("******************** Lista de autos ordenada por modelo y precio*****************************");


        List<Vehiculo> listSortedByModelAndPrice = garaje.getListaVehiculos().stream().sorted( Comparator.comparing(Vehiculo::getModelo).thenComparing(Vehiculo::getCosto)).toList();
        System.out.println(listSortedByModelAndPrice.toString());


        System.out.println("******************** Lista de autos con precio menor a 1000 ****************************");
        List<Vehiculo> listCarsPriceMax1000 = garaje.getListaVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).toList();
        System.out.println(listCarsPriceMax1000.toString());

        System.out.println("********************** Lista de Autos con precio mayor a 1000 **************************");
        List<Vehiculo> listCarsPriceMin1000 = garaje.getListaVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();
        System.out.println(listCarsPriceMin1000.toString());

        System.out.println("********************** Promedio de costo por auto **************************");
        double avgPrice = garaje.getListaVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("El promedio de costo por auto es: " + avgPrice);
    }
}
