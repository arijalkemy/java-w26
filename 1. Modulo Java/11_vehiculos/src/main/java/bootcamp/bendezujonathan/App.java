package bootcamp.bendezujonathan;

import java.util.Comparator;
import java.util.List;

import bootcamp.bendezujonathan.garage.Garage;
import bootcamp.bendezujonathan.garage.Vehiculo;

public class App 
{
    public static void main( String[] args )
    {
        Garage garageFierrero = setUpGarage();
        List<Vehiculo> priceSorted = garageFierrero.orderVehiculos(Comparator.comparing(Vehiculo::getCosto));
        show(priceSorted, "Vehiculos ordenados por precio");
        List<Vehiculo> brandPriceSorted= garageFierrero.orderVehiculos(Comparator.comparing(Vehiculo::getMarca)
                                                                                 .thenComparing(Vehiculo::getCosto));
        show(brandPriceSorted, "Vehiculos ordenados por marca y precio");
        List<Vehiculo> less1000 = garageFierrero.filterVehiculosByPredicate(vehiculo -> vehiculo.getCosto() < 1000);
        show(less1000, "Vehiculos con un costo menor a 1000");
        List<Vehiculo> equalOrGreadter1000 = garageFierrero.filterVehiculosByPredicate(vehiculo -> vehiculo.getCosto() >= 1000);
        show(equalOrGreadter1000, "Vehiculos con un costo de 1000 o mas");

        System.out.printf("%n >> El costo promedio de nuestros vehiculos es: %.2f%n", garageFierrero.averageCost());
    }

    private static Garage setUpGarage() {
        List<Vehiculo> vehiculos = List.of(
            new Vehiculo("GMC", "3500 Club Coupe", 2820.43),
            new Vehiculo("GMC", "Yukon", 4811.18),
            new Vehiculo("Hyundai", "Elantra", 3817.35),
            new Vehiculo("Saturn", "S-Series", 1866.82),
            new Vehiculo("Mazda", "MX-5", 3337.26),
            new Vehiculo("Dodge", "Durango", 3111.18),
            new Vehiculo("BMW", "3 Series", 7931.86),
            new Vehiculo("Chevrolet", "Corvette", 4903.76),
            new Vehiculo("Chevrolet", "Lumina", 1244.46),
            new Vehiculo("Toyota", "Prius Plug-in", 1406.1),
            new Vehiculo("Ford", "Fiesta", 900.50),
            new Vehiculo("Honda", "Civic", 800.75),
            new Vehiculo("Volkswagen", "Golf", 999.99),
            new Vehiculo("Fiat", "500", 1000.00)
        );
        
        return new Garage(1, vehiculos);
    }

    private static void show(List<Vehiculo> vehiculos, String title) {
        String leftAlignFormat = "| %-15s | %-20s | %-10s |%n";
        String delimiter = "+" + "-".repeat(17) + "+" + "-".repeat(22) + "+" + "-".repeat(12) + "+";
        System.out.println(delimiter);
        System.out.format("| %-51s |%n", title);
        System.out.println(delimiter);
        System.out.format("|     Marca       |        Modelo        |   Precio   |%n");
        System.out.println(delimiter);
    
        vehiculos.forEach(vehiculo ->
            System.out.format(leftAlignFormat, vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getCosto())
        );
    
        System.out.println(delimiter);
    }
}
