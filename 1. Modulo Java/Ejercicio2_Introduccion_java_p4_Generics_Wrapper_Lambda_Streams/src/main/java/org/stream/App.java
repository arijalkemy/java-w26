package org.stream;

import logica.Garaje;
import logica.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static List<Vehiculo> vehiculos = new ArrayList<>();
    public static void main( String[] args )
    {
        //Ejemplificar vehiculos
        construirVehiculos();
        //Crear y asignar garaje
        Garaje miGaraje = new Garaje(1, vehiculos);
        //Ejercicio 3
        //Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.
        System.out.println("___________________________________________");
        System.out.println("Organizar vehiculos en el garaje por precio");
        System.out.println("___________________________________________");

        miGaraje.getListaVehiculos().
                                    stream().
                                        sorted((v1, v2)->(v1.getCosto().compareTo(v2.getCosto()))).
                                            forEach(System.out::println);

        System.out.println("___________________________________________");
        //Ejercicio 4
        //De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
        System.out.println("Organizar vehiculos en el garaje por Marca y precio");
        System.out.println("___________________________________________");

        Comparator<Vehiculo> comparador = Comparator.comparing(Vehiculo::getMarca).
                                                                thenComparingInt(Vehiculo::getCosto);
        vehiculos.stream().sorted(comparador).forEach(System.out::println);

        //Ejercicio 5
        //Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000
        // y por último, obtén el promedio total de precios de toda la lista de vehículos.
        System.out.println("___________________________________________");
        System.out.println("Vehiculos economicos");
        System.out.println("___________________________________________");
        List<Vehiculo>  lista_vehiculos_economicos = vehiculos.stream().filter(v -> v.getCosto()<1000).collect(Collectors.toList());
        lista_vehiculos_economicos.forEach(System.out::println);
        Double precio = lista_vehiculos_economicos.stream().mapToDouble(Vehiculo::getCosto).sum();
        System.out.println("Promedio: $"+precio/lista_vehiculos_economicos.size());
        System.out.println("___________________________________________");
        System.out.println("Vehiculos costosos");
        System.out.println("___________________________________________");
        List<Vehiculo> lista_vehiculos_costosos = vehiculos.stream().filter(v -> v.getCosto()>=1000).collect(Collectors.toList());
        lista_vehiculos_costosos.forEach(System.out::println);
        Double precio2 = lista_vehiculos_costosos.stream().mapToDouble(Vehiculo::getCosto).sum();
        System.out.println("Promedio: $"+precio2/lista_vehiculos_costosos.size());




    }

    public static void construirVehiculos(){
        // Crear la lista de vehículos
        // Agregar los vehículos a la lista
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200)); // Corregido el modelo a Corolla
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));
    }
}
