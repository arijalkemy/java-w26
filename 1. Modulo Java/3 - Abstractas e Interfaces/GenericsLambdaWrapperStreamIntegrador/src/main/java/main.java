import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalDouble;

public class main {

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.00));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.00));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500.00));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.00));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.00));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250.00));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.00));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.00));
        vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200.00));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.00));
        vehiculos.add(new Vehiculo("Renault", "logan", 950.00));

        Garage garage = new Garage(1, vehiculos);

        System.out.println("Vehiculos ordenados por costo y marca\n");
        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        // Menores a 1000
        System.out.println("\nMenores a 1000 \n");
        vehiculos.stream()
                .filter(p -> p.getCosto() < 1000)
                .forEach(System.out::println);

        // Mayores o iguales a 1000
        System.out.println("\nMayores o iguales 1000 \n");
        vehiculos.stream()
                .filter(p -> p.getCosto() >= 1000)
                        .forEach(System.out::println);

        System.out.println("\nPromedio \n");
        // promedio
        Double promedio = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println(promedio);
    }
}
