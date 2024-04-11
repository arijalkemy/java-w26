package org.example;

import java.util.List;

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

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {

        String resultado = "Garage{id=" + id + "\n";

        for (Vehiculo vehiculo : vehiculos)
            resultado += vehiculo.toString() + "\n";

        resultado += "}";

        return resultado;
    }
}
