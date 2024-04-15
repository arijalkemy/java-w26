package genericsLambdaStreams;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Crear el garaje y añadir vehículos
        Garaje garaje = new Garaje("1");
        if (garaje.getVehiculos() == null) {
            garaje.setVehiculos(new ArrayList<>()); // Asegúrate de que la lista no sea null
        }
        garaje.getVehiculos().add(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.getVehiculos().add(new Vehiculo("Focus", "Ford", 1200));
        garaje.getVehiculos().add(new Vehiculo("Explorer", "Ford", 2500));
        garaje.getVehiculos().add(new Vehiculo("Uno", "Fiat", 500));
        garaje.getVehiculos().add(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.getVehiculos().add(new Vehiculo("Torino", "Fiat", 1250));
        garaje.getVehiculos().add(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.getVehiculos().add(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.getVehiculos().add(new Vehiculo("Corola", "Toyota", 1200));
        garaje.getVehiculos().add(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.getVehiculos().add(new Vehiculo("Logan", "Renault", 950));

        // Ejercicio 3: Ordenar vehículos por precio
        System.out.println("Vehículos ordenados por precio:");
        garaje.getVehiculos().sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));
        garaje.getVehiculos().forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " - $" + v.getCosto()));

        // Ejercicio 4: Ordenar por marca y luego por precio
        System.out.println("\nVehículos ordenados por marca y precio:");
        garaje.getVehiculos().sort((v1, v2) -> {
            int marcaComparacion = v1.getMarca().compareTo(v2.getMarca());
            if (marcaComparacion == 0) {
                return Double.compare(v1.getCosto(), v2.getCosto());
            }
            return marcaComparacion;
        });
        garaje.getVehiculos().forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " - $" + v.getCosto()));

        // Ejercicio 5: Filtrar por precio y calcular el promedio de precios
        List<Vehiculo> menorA1000 = garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .collect(Collectors.toList());
        List<Vehiculo> mayorIgualA1000 = garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .collect(Collectors.toList());
        double promedioPrecio = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("\nPromedio de precios: $" + promedioPrecio);
        System.out.println("Vehículos con precio menor a $1000:");
        menorA1000.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " - $" + v.getCosto()));
        System.out.println("Vehículos con precio igual o mayor a $1000:");
        mayorIgualA1000.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " - $" + v.getCosto()));
    }
}
