import modelo.Garaje;
import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>(
                List.of(new Vehiculo("Ford","Fiesta",1000d),
                        new Vehiculo("Ford", "Focus",1200d),
                        new Vehiculo("Ford","Explorer",2500d),
                        new Vehiculo("Fiat", "Uno",500d),
                        new Vehiculo("Fiat", "Cronos",1000d),
                        new Vehiculo("Fiat", "Torino",1250d),
                        new Vehiculo("Chevrolet", "Aveo", 1250d),
                        new Vehiculo("Chevrolet", "Spin", 2500d),
                        new Vehiculo("Toyota", "Corolla", 1200d),
                        new Vehiculo("toyota", "Fortuner", 3000d),
                        new Vehiculo("Renault", "Logan", 950d)
                        )
        );

        Garaje garaje = new Garaje(1,vehiculos);

        System.out.println("EJ 3 - ORDENAMIENTO DE MENOR A MAYOR");

        List<Vehiculo> vehiculosOrdenadosPorPrecio =
                garaje.
                        getVehiculos()
                .stream().sorted((vehiculo1, vehiculo2) ->
                        (int) (vehiculo1.getCosto() - vehiculo2.getCosto()))
                .toList();

        mostrarVehiculos(vehiculosOrdenadosPorPrecio);

        System.out.println();
        System.out.println();
        System.out.println("EJ4 - ORDENAMIENTO POR MARCA Y POR PRECIO");

        System.out.println();
        List<Vehiculo> vehiculosOrdenadosPorPrecioYMarca =
                garaje
                        .getVehiculos()
                        .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .toList();

        mostrarVehiculos(vehiculosOrdenadosPorPrecioYMarca);

        System.out.println();
        System.out.println();
        System.out.println("EJ5");

        List<Vehiculo> vehiculosNoMayoresA1000 = garaje.getVehiculos().stream().filter(v -> v.getCosto()<1000).toList();

        List<Vehiculo> vehiculosMayoresOIgualesA1000 = garaje.getVehiculos().stream().filter(v -> v.getCosto() > 1000).toList();

        OptionalDouble promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();

        System.out.println();

        System.out.println("Vehiculos no mayores a 1000:");
        mostrarVehiculos(vehiculosNoMayoresA1000);

        System.out.println();
        System.out.println();
        System.out.println("Vehiculos mayores o iguales a 1000");
        mostrarVehiculos(vehiculosMayoresOIgualesA1000);

        System.out.println();
        System.out.println();
        if(promedio.isPresent()){
            double promedioResult = promedio.getAsDouble();

            System.out.println("PROMEDIO: " + promedioResult);
        }

    }

    public static void mostrarVehiculos(List<Vehiculo> vehiculos){
        for(Vehiculo vehiculo : vehiculos){
            System.out.println(vehiculo.getMarca() + " | " + vehiculo.getModelo() + " | " + vehiculo.getCosto());
        }
    }
}
