package RecapitulandoJava;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Garage {
    private String id;
    private List<Vehiculo> vehiculos;

    public Garage(String id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void imprimirListaVehiculosPorPrecio(){
        System.out.println("Lista Vehiculos ordenados por precio");
        Stream<Vehiculo> lista = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto));
        lista.forEach(vehiculo -> System.out.println(vehiculo.toString()));
        System.out.println("\n");
    }

    public void imprimirListaVehiculosPorMarcaYPrecio(){
        System.out.println("Lista Vehiculos ordenados por marca y precio");
        Stream<Vehiculo> lista = vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Comparator.comparing(Vehiculo::getCosto)));

        lista.forEach(vehiculo -> System.out.println(vehiculo.toString()));
        System.out.println("\n");

    }

    public void imprimirListaVehiculosNoMayorAPrecio1000(){
        System.out.println("Lista Vehiculos precio menor igual a 1000");
        Stream<Vehiculo> lista = vehiculos.stream().filter(x -> x.getCosto() <= 1000).sorted(Comparator.comparing(Vehiculo::getCosto));
        lista.forEach(vehiculo -> System.out.println(vehiculo.toString()));
        System.out.println("\n");
    }
    public void imprimirListaVehiculosPrecioMayorIgual1000(){
        System.out.println("Lista Vehiculos precio mayor igual a 1000");
        Stream<Vehiculo> lista = vehiculos.stream().filter(x -> x.getCosto() >= 1000).sorted(Comparator.comparing(Vehiculo::getCosto));
        lista.forEach(vehiculo -> System.out.println(vehiculo.toString()));
        System.out.println("\n");
    }

    public void imprimirPromedioDePrecios(){
        System.out.println("Lista de promedio de costos de vehiculos");
        double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("Costo promedio: " + promedio + "\n");
    }
}
