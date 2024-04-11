package org.example;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args ){
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        listaVehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        listaVehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        listaVehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        listaVehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        listaVehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        listaVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        listaVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        listaVehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        listaVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        listaVehiculos.add(new Vehiculo("Logan", "Renault", 950));
        Garage garage = new Garage();
        garage.setListaVehiculos(listaVehiculos);

        // Imprimir los vehículos ordenados por precio
        garage.imprimirVehiculosOrdenadosPorPrecio();
        System.out.printf("\n\n");
        // Imprimir los vehículos ordenados por marca y precio
        garage.imprimirVehiculosOrdenadosPorMarcaYPrecio();

        System.out.printf("\n\n");

        // Imprimir vehículos con precio no mayor a 1000
        System.out.println("Vehículos con precio no mayor a 1000:");
        garage.vehiculosConPrecioNoMayorA1000().forEach(System.out::println);
        System.out.printf("\n\n");

        // Imprimir vehículos con precio mayor o igual a 1000
        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        garage.vehiculosConPrecioMayorOIgualA1000().forEach(System.out::println);
        System.out.printf("\n\n");

        // Imprimir el promedio total de precios
        System.out.println("\nPromedio total de precios:");
        System.out.println(garage.promedioDePrecios());
    }

}
