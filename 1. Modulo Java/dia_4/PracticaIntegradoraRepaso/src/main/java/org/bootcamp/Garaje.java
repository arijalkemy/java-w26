package org.bootcamp;

import java.util.Comparator;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;


    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void mostrarVehiculos() {
        vehiculos.stream().forEach(System.out::println);
    }

    public void ordernarPorPrecio() {
        vehiculos = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).toList();
    }

    public void ordernarVehiculosPorMarcaYPecio() {
        vehiculos = vehiculos.stream()
                .sorted(Comparator
                        .comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getPrecio)).toList();
    }

    public List listaMenorAMil(){
        return vehiculos.stream().filter(x -> x.getPrecio()< 1000).toList();

    }

    public List listaMayorOIgualAMil(){
        return vehiculos.stream().filter(x -> x.getPrecio()>= 1000).toList();


    }

    public double promedio (){
        return vehiculos.stream().mapToDouble(x -> x.getPrecio()).average().orElse(0.0);
    }

}
