package Clases;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehicuos() {
        return vehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehicuos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void ordenarVehiculosPorPrecio() {
        vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getCosto)).forEach( x ->System.out.println(x.toString()));
    }

    public void ordenarVehiculosPorPrecioMarca() {
        vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getCosto)).sorted( (x,y) ->
            x.getMarca().compareTo(y.getMarca())
        ).forEach( x ->System.out.println(x.toString()));
    }

    public void costosMenoresA( int precio ){
        vehiculos.stream().filter( x -> x.getCosto() < precio ).forEach( x ->System.out.println(x.toString()));
    }

    public void costosMayoresA( int precio ){
        vehiculos.stream().filter( x -> x.getCosto() > precio ).forEach( x ->System.out.println(x.toString()));
    }

    public double costoPromedio(){

        OptionalDouble average = vehiculos.stream().mapToInt(Vehiculo::getCosto).average();
        if(average.isEmpty()){
            return 0.0;
        }
        return average.getAsDouble();
    }
}
