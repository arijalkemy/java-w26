package org.ggomezr;

import java.util.*;
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
        List<Vehiculo> vehiculosOrdenadosPorCosto = new ArrayList<>(vehiculos);

        Collections.sort(vehiculosOrdenadosPorCosto, Comparator.comparing(Vehiculo::getCosto));

        for(Vehiculo vehiculo: vehiculosOrdenadosPorCosto){
            System.out.println(vehiculo);
        }
    }

    public void ordenarPorMarcaYCosto(){
        List<Vehiculo> vehiculosOrdenadosPorMarcaYCosto = new ArrayList<>(vehiculos);

        Collections.sort(vehiculosOrdenadosPorMarcaYCosto, Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

        for(Vehiculo vehiculo: vehiculosOrdenadosPorMarcaYCosto){
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
