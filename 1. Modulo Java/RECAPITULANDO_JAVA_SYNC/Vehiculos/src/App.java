import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Garaje garaje = new Garaje();
        garaje.agregarVehiculo("Ford", "Fiesta", 1000);
        garaje.agregarVehiculo("Ford", "Focus", 1200);
        garaje.agregarVehiculo("Ford", "Explorer", 2500);
        garaje.agregarVehiculo("Fiat", "Uno", 500);
        garaje.agregarVehiculo("Fiat", "Cronos", 1000);
        garaje.agregarVehiculo("Fiat", "Torino", 1250);
        garaje.agregarVehiculo("Chevrolet", "Aveo", 1250);
        garaje.agregarVehiculo("Chevrolet", "Spin", 2500);
        garaje.agregarVehiculo("Toyota", "Corola", 1200);
        garaje.agregarVehiculo("Toyota", "Fortuner", 3000);
        garaje.agregarVehiculo("Renault", "Logan", 950);

        garaje.getVehiculos().stream().sorted().forEach(vehiculo -> {System.out.println(vehiculo);});
        System.out.println("--------");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(vehiculo -> System.out.println(vehiculo));
        //Explicación: se orden por marca y si la marca se repite entre los que se repiten se ordenan por costo


        //System.out.println("--------");
        //garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca)).sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(vehiculo -> System.out.println(vehiculo));
        //Explicación el doble sorted hace que se ordene por marca, y luego los coge todos y los ordena por costo        


        System.out.println("--------- Comparaciones < 1000 y >= 1000");
        List<Vehiculo> vehiculos_menores = 
        garaje
        .getVehiculos()
        .stream()
        .filter(vehiculo -> vehiculo.getCosto() < 1000)
        .collect(Collectors.toList());

        System.out.println(vehiculos_menores);

        List<Vehiculo> vehiculos_mayores = 
        garaje
        .getVehiculos()
        .stream()
        .filter(vehiculo -> vehiculo.getCosto() >= 1000)
        .collect(Collectors.toList());
        System.out.println("---");
        System.out.println(vehiculos_mayores);


        System.out.println("--------");

        double promedio = garaje
        .getVehiculos()
        .stream()
        .mapToDouble(Vehiculo::getCosto).average().getAsDouble();

        System.out.println("Promedio: " + promedio);
    }
}
