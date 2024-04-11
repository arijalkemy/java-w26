package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Garage {
    private int id;
    List<Vehiculo> listaVehiculos = new ArrayList<>();

    public Garage(int id, List<Vehiculo> listaVehiculos){
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public Garage (){

    }
    public int getId() {
        return id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    // Método para obtener vehículos con precio no mayor a 1000
    public List<Vehiculo> vehiculosConPrecioNoMayorA1000() {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());
    }

    //  Método para obtener vehículos con precio mayor o igual a 1000
    public List<Vehiculo> vehiculosConPrecioMayorOIgualA1000() {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
    }



    // Método para ordenar la lista de vehículos por precio de menor a mayor e imprimir
    public void imprimirVehiculosOrdenadosPorPrecio() {
        listaVehiculos.sort((vehiculo1, vehiculo2) -> Double.compare(vehiculo1.getCosto(), vehiculo2.getCosto()));
        listaVehiculos.forEach(System.out::println);
    }

    public void imprimirVehiculosOrdenadosPorMarcaYPrecio() {
        listaVehiculos.sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto));
        listaVehiculos.forEach(System.out::println);
    }
    // Método para calcular el promedio total de precios
    public double promedioDePrecios() {
        return listaVehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0); // En caso de que la lista esté vacía, devuelve 0
    }


}
