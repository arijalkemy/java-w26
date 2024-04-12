import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args){

        //creo la lista de vehiculos.
        List<Vehiculo> listaAutos = new ArrayList<>(Arrays.asList(
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
                ));

        Garage garage = new Garage(listaAutos);

        //se organiza la lista por valor de vehiculo y se imprime
        System.out.println("********* Lista ordenada por valor de vehiculo *********");
         garage.getListaVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo :: getCosto))
                .forEach(System.out :: println);

        //se organiza lista por marca y precio
        System.out.println("********* Lista ordenada por marca y valor de vehiculo *********");
        garage.getListaVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto)
                .thenComparing(Vehiculo :: getMarca))
                .forEach(System.out :: println);


        //lista con precios mayor a 1000
        System.out.println("********* Lista de vehiculos con precio mayor o igual a 1000 *********");
        garage.getListaVehiculos()
                .stream()
                .filter(Vehiculo::getMayor1000)
                .forEach(System.out :: println);

        //lista con precios menores a 1000
        System.out.println("********* Lista de vehiculos con precio menor a 1000 *********");
        garage.getListaVehiculos()
                .stream()
                .filter(Vehiculo::getMenor1000)
                .forEach(System.out :: println);

        //promedio de precio de los vehiculos
        System.out.println("********* Promedio de precio de vehiculos *********");
        double promedioValor = garage.getListaVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();

        System.out.println(promedioValor);

    }

}
