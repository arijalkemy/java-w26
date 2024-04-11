import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage(1);
        garage.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garage.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garage.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garage.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garage.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garage.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garage.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.addVehiculo(new Vehiculo("Toyota", "Corolla", 1200));
        garage.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.addVehiculo(new Vehiculo("Renault", "Logan", 950));

        List<Vehiculo> autos = garage.getVehiculos();
        autos.sort(Comparator.comparingInt(Vehiculo::getCosto));
        autos.sort(Comparator.comparing(Vehiculo::getMarca));

        List<Vehiculo> filteredAutosMenor = garage.getVehiculos().stream().filter(auto -> auto.getCosto() <= 1000).collect(Collectors.toList());
        List<Vehiculo> filteredAutosMayor = garage.getVehiculos().stream().filter(auto -> auto.getCosto() > 1000).collect(Collectors.toList());

        for(int i = 0; i < autos.size(); i++){
            Vehiculo cur = autos.get(i);
            System.out.println(i + ". Marca: " + cur.getMarca() + ". Modelo: " + cur.getModelo() + ". Costo: " + cur.getCosto());
        }
        System.out.println("Promedio de Costos: $" + autos.stream().mapToInt(Vehiculo::getCosto).average().orElse(0));
    }
}
