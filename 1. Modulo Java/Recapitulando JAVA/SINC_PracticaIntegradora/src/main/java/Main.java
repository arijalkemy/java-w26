import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        // Agrego los vehículos a la lista
        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, listaVehiculos);

        System.out.println("3. Lista ordenada por precio (de menor a mayor)\n");
        listaVehiculos.stream()
                .sorted(Comparator.comparingDouble(x -> x.getCosto()))
                .forEach(x -> System.out.println(x.toString()));

        System.out.println("\n4. Lista ordenada por marca y precio (de menor a mayor)\n");
        listaVehiculos.stream()
                .sorted(Comparator.comparingDouble(x -> x.getCosto()))
                .sorted(Comparator.comparing(x -> x.getMarca()))
                .forEach(x -> System.out.println(x));


        System.out.println("\n5.a. Lista con vehiculos con un costo menor a 1000\n");
        List<Vehiculo> vehiculosCostoMenorAMil = listaVehiculos.stream()
                                                    .filter(x -> x.getCosto() < 1000)
                                                    .toList();

        for (Vehiculo vehiculo : vehiculosCostoMenorAMil) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("\n5.b. Lista con vehiculos con un costo mayor o igual a 1000\n");
        List<Vehiculo> vehiculosCostoMayorIgualAMil = listaVehiculos.stream()
                .filter(x -> x.getCosto() >= 1000)
                .toList();

        for (Vehiculo vehiculo : vehiculosCostoMayorIgualAMil) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("\n5.c. Promedio de costos de la lista de vehiculos\n");
        double promedioCostosVehiculos = listaVehiculos.stream()
                                                    .mapToDouble(x -> x.getCosto())
                                                    .average()
                                                    .orElse(0);

        System.out.println("El promedio de costos de vehiculos es: " + promedioCostosVehiculos);
    }
}
