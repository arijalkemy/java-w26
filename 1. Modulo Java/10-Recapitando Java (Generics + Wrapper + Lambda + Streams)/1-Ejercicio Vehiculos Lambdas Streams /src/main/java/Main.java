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
        // Ordenado por costo
        garage.getVehicles()
                .stream()
                .sorted(Comparator.comparing(Vehicle::getCost))
                .forEach(System.out::println);
        System.out.println(" -------------- ");

        // Ordenado por Marca y despues costo
        garage.getVehicles()
                .stream()
                .sorted(Comparator.comparing(Vehicle::getBrand)
                        .thenComparing(Vehicle::getCost))
                .forEach(System.out::println);
        System.out.println(" -------------- ");


        // Filtrar por costo
        garage.getVehicles()
                .stream()
                .filter((x) -> x.getCost() < 1000)
                .forEach(System.out::println);
        System.out.println(" -------------- ");
        garage.getVehicles()
                .stream()
                .filter((x) -> x.getCost() >= 1000)
                .forEach(System.out::println);

        System.out.println(" -------------- ");
        double avg = garage.getVehicles()
                .stream()
                .mapToDouble(Vehicle::getCost)
                .average()
                .orElse(0.0);
        System.out.println("Promedio : " + avg);



    }
}
