import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage(1);

        garage.getVehiculos().add(new Vehiculo("Fiesta", "Ford", 1000));
        garage.getVehiculos().add(new Vehiculo("Focus", "Ford", 1200));
        garage.getVehiculos().add(new Vehiculo("Explorer", "Ford", 2500));
        garage.getVehiculos().add(new Vehiculo("Uno", "Fiat", 500));
        garage.getVehiculos().add(new Vehiculo("Cronos", "Fiat", 1000));
        garage.getVehiculos().add(new Vehiculo("Torino", "Fiat", 1250));
        garage.getVehiculos().add(new Vehiculo("Aveo", "Chevrolet", 1250));
        garage.getVehiculos().add(new Vehiculo("Spin", "Chevrolet", 2500));
        garage.getVehiculos().add(new Vehiculo("Corola", "Toyota", 1200));
        garage.getVehiculos().add(new Vehiculo("Fortuner", "Toyota", 3000));
        garage.getVehiculos().add(new Vehiculo("Logan", "Renault", 950));

        //garaje.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));

        garage.getVehiculos().sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getCosto)
        );

        System.out.println("Vehículos en el garaje:");
        for (Vehiculo vehiculo : garage.getVehiculos()) {
            System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo() + ", Precio: $" + vehiculo.getCosto());
        }

        List<Vehiculo> vehiculosMenos1000 = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .toList();

        List<Vehiculo> vehiculosMas1000 = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();

        double promedioTotal = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("\nVehículos con precio no mayor a 1000:");
        vehiculosMenos1000.forEach(v -> System.out.println("Marca: " + v.getMarca() + ", Modelo: " + v.getModelo() + ", Precio: $" + v.getCosto()));

        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        vehiculosMas1000.forEach(v -> System.out.println("Marca: " + v.getMarca() + ", Modelo: " + v.getModelo() + ", Precio: $" + v.getCosto()));

        System.out.println("\nPromedio total de precios de todos los vehículos: $" + promedioTotal);
    }
}
