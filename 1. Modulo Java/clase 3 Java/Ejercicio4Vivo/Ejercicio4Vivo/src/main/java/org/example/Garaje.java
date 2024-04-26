package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garaje {
    private long idGarage ;
    private List<Vehiculo> listaVehiculos ;

    public Garaje(long idGarage, List<Vehiculo> listaVehiculos) {
        this.idGarage = idGarage;
        this.listaVehiculos = listaVehiculos;
    }

    public long getIdGarage() {
        return idGarage;
    }

    public void setIdGarage(long idGarage) {
        this.idGarage = idGarage;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    public void ordenarVehiculosPorPrecio(){
        listaVehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto));
    }
    public void ordenarVehiculosPorNombreYPrecio(){
        listaVehiculos.sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto)
        );
    }
    public List<Vehiculo> obtenerVehiculosMenorAMil() {
       return listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<1000).toList();
    }
    public List<Vehiculo> obtenerVehiculosMayorAMil() {
        return listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).toList();
    }
    public double obtenerPromedioCostoVehiculo(){
        return listaVehiculos.stream().mapToDouble(vehiculo -> vehiculo.getCosto()).sum()
                /listaVehiculos.size();
    }

    @Override
    public String toString() {
        return "Garage{" +
                "idGarage=" + idGarage +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }
}
