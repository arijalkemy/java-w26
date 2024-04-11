package org.example;

import org.example.clases.Garage;
import org.example.clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // Crear los vehículos
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
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

        // Crear la instancia de garage
        Garage garage = new Garage(1, vehiculos);

        garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getPrecio));
        for (Vehiculo v : vehiculos) {
            System.out.println(v.toString());
        }

        //menu
        Scanner scan = new Scanner(System.in);
        int opc = 0;
        do {
            opc = mostrarMenu();
            switch (opc) {
                case 1:
                    garage.ordernarPorPrecio();
                    for (Vehiculo v : vehiculos) {
                        System.out.println(v.toString());
                    }
                    break;
                case 2:
                    garage.ordenarPorPrecioyMarca();
                    for (Vehiculo v : vehiculos) {
                        System.out.println(v.toString());
                    }
                    break;
                case 3:
                    garage.mostrarVehiculoMenorQueMil();
                    break;
                case 4:
                    garage.mostrarVehiculoMayorQueMil();
                    break;
                case 5:
                    System.out.println("El promedio final de los precios del garage es igual a " + garage.promediodePrecios());
                    break;
                case 6:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida");
            }
            System.out.println("Apriete enter para continuar");
            scan.nextLine();
        } while (opc != 6);
    }

    public static int mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("***** Bootcamp Java 11/04 Turno Tarde*****");
        System.out.println("1) Mostrar Garage Ordenado por Precio");
        System.out.println("2) Mostrar Garage Ordenado por Marca y precio");
        System.out.println("3) Mostrar Vehiculos precio menor a mil");
        System.out.println("4) Mostrar Vehiculos precio mayor o igual a mil");
        System.out.println("5) Mostrar Promedio de precios de vehiculos");
        System.out.println("6) Salir");
        System.out.println("Elija una opcion: ");
        return scan.nextInt();
    }

}
