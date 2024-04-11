package org.ggomezr;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Garaje {
    private int id;
    private static int ultimoId;
    private List<Vehiculo> vehiculos;

    public Garaje(List<Vehiculo> vehiculos) {
        this.id = ++ultimoId;
        this.vehiculos = vehiculos;
    }

    public void ordenarPorCosto(){
        Collections.sort(vehiculos, Comparator.comparing(Vehiculo::getCosto));

        for(Vehiculo vehiculo: vehiculos){
            System.out.println(vehiculo);
        }
    }

    public void ordenarPorMarcaYCosto(){
        Collections.sort(vehiculos, Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

        for(Vehiculo vehiculo: vehiculos){
            System.out.println(vehiculo);
        }
    }

    public void obtenerVehiculosCostoMenorA1000(){
        List<Vehiculo> vehiculosMenores1000 = vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).toList();
        System.out.println(vehiculosMenores1000);
    }

    public void obtenerVehiculosCostoMayorA1000(){
        List<Vehiculo> vehiculosMayores1000 = vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();
        System.out.println(vehiculosMayores1000);
    }

    public void obtenerPromedioPreciosVehiculos(){
        double promedioTotal = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
        System.out.println("Promedio total del precio de todos los vehiculos: " + promedioTotal);
    }

    public int getId() {
        return id;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Garaje.ultimoId = ultimoId;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
