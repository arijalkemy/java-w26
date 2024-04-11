package org.example.clases;

import java.util.ArrayList;
import java.util.Comparator;

public class Garage {
    private int id;
    private ArrayList<Vehiculo> vehiculos ;

    public Garage(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void ordernarPorPrecio(){
        this.vehiculos.sort(Comparator.comparing(Vehiculo::getPrecio));
    }
    public void ordenarPorPrecioyMarca(){
        this.vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio));
    }
    public double promediodePrecios(){
       return this.vehiculos.stream().mapToDouble(Vehiculo::getPrecio).sum()/this.vehiculos.size();
    }
    public void mostrarVehiculoMenorQueMil(){
        this.vehiculos.stream().filter(v -> v.getPrecio() < 1000).forEach(System.out::println);
    }
    public void mostrarVehiculoMayorQueMil(){
        this.vehiculos.stream().filter(v -> v.getPrecio() >= 1000).forEach(System.out::println);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public void mostrarPrecioMenoraMayor(){
    }
}
