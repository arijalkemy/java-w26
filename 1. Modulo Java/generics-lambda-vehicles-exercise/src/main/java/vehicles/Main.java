package vehicles;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1, List.of(
                new Vehiculo("Fiesta", "Ford", 1000),
                new Vehiculo("Focus", "Ford", 1200),
                new Vehiculo("Explorer", "Ford", 2500),
                new Vehiculo("Uno", "Fiat", 500),
                new Vehiculo("Cronos", "Fiat", 1000),
                new Vehiculo("Torino", "Fiat", 1250),
                new Vehiculo("Aveo", "Chevrolet", 1250),
                new Vehiculo("Spin", "Chevrolet", 2500),
                new Vehiculo("Corola", "Toyota", 1200),
                new Vehiculo("Fortuner", "Toyota", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

        List<Vehiculo> vehiculosDelGaraje =  garaje.getVehiculos();
        System.out.println("Ordenados por precio");
        vehiculosDelGaraje.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("Ordenados por marca y precio");
        vehiculosDelGaraje.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);
        System.out.println("Precio < 1000");
        vehiculosDelGaraje.stream().filter((v)->v.getCosto() < 1000).forEach(System.out::println);
        System.out.println("Precio >= 1000");
        vehiculosDelGaraje.stream().filter((v)->v.getCosto() >= 1000).forEach(System.out::println);

        int sum = vehiculosDelGaraje.stream().map((v)->v.getCosto()).reduce(0, Integer::sum);
        int count = vehiculosDelGaraje.size();
        System.out.println("Promedio: " + sum/count);

    }
}
