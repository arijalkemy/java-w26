import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehiculo[] vehiculos = {
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        };

        Garaje garaje = new Garaje(1);
        garaje.agregarVehiculo(vehiculos);

        System.out.println("Lista de autos sin ordenamiento:");
        garaje.getVehiculos().forEach(System.out::println);

        System.out.println();

        System.out.println("Lista de autos ordenados por precio de menor a mayor:");
        garaje.ordenarVehiculos().forEach(System.out::println);

        System.out.println();

        System.out.println("Lista de autos ordenados por marca y precio");
        garaje.ordenarPorMarcaYPrecio().forEach(System.out::println);

        System.out.println();

        System.out.println("Autos con precio no mayor a mil");
        List<Vehiculo> vehiculos2 = garaje.obtenerAutosConPrecioNoMayorAMil();
        vehiculos2.forEach(System.out::println);
        System.out.println("Promedio: " + garaje.calcularPromedio(vehiculos2));

        System.out.println();

        System.out.println("Autos con precio mayor o igual a mil");
        List<Vehiculo> vehiculo3 = garaje.obtenerAutosConPrecioMayorOIgualAMil();
        vehiculo3.forEach(System.out::println);
        System.out.println("Promedio: " + garaje.calcularPromedio(vehiculo3));




    }
}
