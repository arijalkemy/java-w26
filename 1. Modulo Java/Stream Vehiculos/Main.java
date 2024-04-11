import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(
                1,
                Arrays.asList(
                        new Vehicle("Ford", "Fiesta", 1000D),
                        new Vehicle("Ford", "Focus", 1200D),
                        new Vehicle("Ford", "Explorer", 2500D),
                        new Vehicle("Fiat", "Uno", 500D),
                        new Vehicle("Fiat", "Cronos", 1000D),
                        new Vehicle("Fiat", "Torino", 1250D),
                        new Vehicle("Chevrolet", "Aveo", 1250D),
                        new Vehicle("Chevrolet", "Spin", 2500D),
                        new Vehicle("Toyota", "Corola", 1200D),
                        new Vehicle("Toyota", "Fortuner", 3000D),
                        new Vehicle("Renault", "Logan", 950D)
                )
        );

        garage.getVehicles()
                .stream()
                .sorted((i, j) -> {
                    if (Objects.equals(i.getPrice(), j.getPrice())) return 0;
                    return (i.getPrice() >= j.getPrice()) ? 1 : -1;
                })
                .forEach(System.out::println);
        System.out.println("#2");
        garage.getVehicles()
                .stream()
                .sorted(Comparator.comparing(Vehicle::getPrice))
                .forEach(System.out::println);
        System.out.println("#3");

        garage.getVehicles().sort((x, y) -> Double.compare(x.getPrice(), y.getPrice()));
        garage.getVehicles().forEach(System.out::println);
        List<Vehicle> greatestPrice1000 = garage.getVehicles().stream().filter(Vehicle::greaterThan1000).toList();
        greatestPrice1000.forEach(System.out::println);
        Double average = garage.getVehicles().stream().mapToDouble(Vehicle::getPrice).average().orElse(0);
        System.out.println(average);
        System.out.println("#4");
        garage.getVehicles()
                .stream()
                .sorted(Comparator.comparing(Vehicle::getPrice).thenComparing(Vehicle::getBrand).thenComparing(Vehicle::getModel))
                .forEach(System.out::println);
    }
}
