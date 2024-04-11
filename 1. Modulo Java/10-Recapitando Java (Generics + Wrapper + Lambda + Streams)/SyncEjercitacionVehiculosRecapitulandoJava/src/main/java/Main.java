import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehiclesList = new ArrayList<>();
        vehiclesList.add(new Vehicle("Ford", "Fiesta", 1000));
        vehiclesList.add(new Vehicle("Ford", "Focus", 1200));
        vehiclesList.add(new Vehicle("Ford", "Explorer", 2500));
        vehiclesList.add(new Vehicle("Fiat", "Uno", 500));
        vehiclesList.add(new Vehicle("Fiat", "Cronos", 1000));
        vehiclesList.add(new Vehicle("Fiat", "Torino", 1250));
        vehiclesList.add(new Vehicle("Chevrolet", "Aveo", 1250));
        vehiclesList.add(new Vehicle("Chevrolet", "Spin", 2500));
        vehiclesList.add(new Vehicle("Toyota", "Corola", 1200));
        vehiclesList.add(new Vehicle("Toyota", "Fortuner", 3000));
        vehiclesList.add(new Vehicle("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehiclesList);
        // ordenado por precio
        System.out.println("---------------");
        garage.getVehicles()
                .sort(Comparator.comparingInt(Vehicle::getCost));
        garage.getVehicles().forEach(System.out::println);

        // ordenado por marca y luego por precio
        System.out.println("---------------");
        garage.getVehicles()
                .sort(Comparator.comparing(Vehicle::getBrand)
                        .thenComparing(Vehicle::getCost));
        garage.getVehicles().forEach(System.out::println);

        // Filtrado por precio no menor a 1000
        System.out.println("---------------");
        garage.getVehicles()
            .stream()
                .sorted()


    }
}
