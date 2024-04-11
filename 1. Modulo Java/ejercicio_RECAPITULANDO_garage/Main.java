import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Garage garaje = new Garage(1);

        garaje.getVehiculos().add(new Vehiculo("Ford Fiesta", "Ford", 1000));
        garaje.getVehiculos().add(new Vehiculo("Ford Focus", "Ford", 1200));
        garaje.getVehiculos().add(new Vehiculo("Ford Explorer", "Ford", 2500));
        garaje.getVehiculos().add(new Vehiculo("Fiat Uno", "Fiat", 500));
        garaje.getVehiculos().add(new Vehiculo("Fiat Cronos", "Fiat", 1000));
        garaje.getVehiculos().add(new Vehiculo("Fiat Torino", "Fiat", 1250));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet Aveo", "Chevrolet", 1250));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet Spin", "Chevrolet", 2500));
        garaje.getVehiculos().add(new Vehiculo("Toyota Corola", "Toyota", 1200));
        garaje.getVehiculos().add(new Vehiculo("Toyota Fortuner", "Toyota", 3000));
        garaje.getVehiculos().add(new Vehiculo("Renault Logan", "Renault", 950));

        System.out.println("*****EJERCICIO 3*******");
        garaje.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getPrecio));
        System.out.println("Lista de vehiculos ordenados de menor a mayor precio: ");
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println(vehiculo.getModelo() + " --> Precio: $" + vehiculo.getPrecio());
        }
        System.out.println("******EJERCICIO 4*******");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getPrecio));
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println(vehiculo.getMarca() + " --> Modelo:" + vehiculo.getModelo() + " --> Precio: $" + vehiculo.getPrecio());
        }

        List<Vehiculo> precioMenor1000 = new ArrayList<>();
        List<Vehiculo> precioMayor1000 = new ArrayList<>();

        double sumaTotal = 0;

        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            if (vehiculo.getPrecio() < 1000) {
                precioMenor1000.add(vehiculo);
            } else {
                precioMayor1000.add(vehiculo);
            }
            sumaTotal += vehiculo.getPrecio();
        }
        double promedio = sumaTotal / precioMayor1000.size();
        System.out.println("Cantidad de autos: " + precioMayor1000.size());
        System.out.println("Suma Total: " + sumaTotal);
        System.out.println("Promedio: " + promedio);

        System.out.println("Vehiculos menores a 1000: ");
        for (Vehiculo vehiculo : precioMenor1000) {
            System.out.println(vehiculo.getModelo() + " " + vehiculo.getPrecio());
        }
        System.out.println("Vehiculos mayores o iguales a 1000: ");
        for (Vehiculo vehiculo : precioMayor1000) {
            System.out.println(vehiculo.getModelo() + " " + vehiculo.getPrecio());
        }

    }
}