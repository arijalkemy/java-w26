import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       List<Vehiculo> vehiculos = new ArrayList<>();
       vehiculos.add(new Vehiculo("Fiesta","Ford",1000));
       vehiculos.add(new Vehiculo("Focus","Ford",1200));
       vehiculos.add(new Vehiculo("Explorer","Ford",2500));
       vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
       vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
       vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
       vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
       vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
       vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
       vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
       vehiculos.add(new Vehiculo("Logan", "Renault", 950));

       Garage garaje = new Garage(1,vehiculos);

       //Ejercicio 3
       System.out.println("------------------------");
       garaje.getVehiculos().sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));
       garaje.getVehiculos().forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + " - $" + v.getCosto()));

       //Ejercicio 4
       System.out.println("------------------");
       vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

       System.out.println("Vehiculos ordenados por marca y precio:");
       for (Vehiculo vehiculo : vehiculos) {
          System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo() + ", Precio: " + vehiculo.getCosto());
       }

       List<Vehiculo> vehiculosMenor = vehiculos;
       vehiculosMenor.stream().filter(v -> v.getCosto() < 1000).toList();

       List<Vehiculo> vehiculosMayor = vehiculos;
       vehiculosMayor.stream().filter(v -> v.getCosto() >= 1000).toList();

       //vehiculos.forEach(v -> v.getCosto().maptoInt());
       double promedioPrecio = garaje.getVehiculos().stream()
               .mapToDouble(Vehiculo::getCosto)
               .average()
               .orElse(0);
    }
}