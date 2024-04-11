package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    List<Vehiculo> vehiculos = new ArrayList<>();
    public int getId() {
        return id;
    }
    public void addVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void printVehiculos(){
        for(Vehiculo vehiculo : vehiculos){
            System.out.println(vehiculo.getModelo());
        }
    }

}
