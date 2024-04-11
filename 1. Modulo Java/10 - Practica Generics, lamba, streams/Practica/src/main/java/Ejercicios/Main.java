package Ejercicios;

import Clases.Garage;
import Clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Creo lista de vehiculos
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        //Agrego los vehiculos a la lista
        vehiculos.add(new Vehiculo("Ford","Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford","Focus", 1200));
        vehiculos.add(new Vehiculo("Ford","Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat","Uno", 500));
        vehiculos.add(new Vehiculo("Fiat","Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat","Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota","Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault","Logan", 950));

        //Creo el garage con los vehiculos
        Garage garage = new Garage(1, vehiculos);

        //Ejercicio 3, ordenar por precio e imprimir vehiculos:
        System.out.println("Comparación por precio");
        garage.ordenarVehiculosPorPrecio();

        System.out.println("-----------------");

        //Ejercicio 4, ordenar por precio y marca e imprimir vehiculos:
        System.out.println("Comparación por precio y marca");
        garage.ordenarVehiculosPorPrecioMarca();

        System.out.println("-----------------");

        //Ejercicio 5
        System.out.println("Lista de vehiculos con costo menor a 1000$");
        garage.costosMenoresA(1000);

        System.out.println("-----------------");

        System.out.println("Lista de vehiculos con costo mayor a 999$");
        garage.costosMayoresA(999);

        System.out.println("-----------------");

        System.out.println("Costo promedio de los vehiculos: " + garage.costoPromedio());
    }
}
