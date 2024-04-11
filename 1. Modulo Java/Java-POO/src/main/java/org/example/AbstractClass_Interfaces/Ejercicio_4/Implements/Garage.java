package org.example.AbstractClass_Interfaces.Ejercicio_4.Implements;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Garage {

    private int id;
    private List<Vehicle> vehicles;


    public List<Vehicle> vehiclesLessThan(int cost){
        return vehicles.stream().filter(vehicle -> vehicle.getCost() < cost).toList();
    }

    public List<Vehicle> vehiclesGreaterEqual(int cost){
        return vehicles.stream().filter(vehicle -> vehicle.getCost() >= cost).toList();
    }

    public Double calcAveragePrice(){
        return vehicles.stream().mapToDouble(Vehicle::getCost).average().orElse(0);
    }
}
