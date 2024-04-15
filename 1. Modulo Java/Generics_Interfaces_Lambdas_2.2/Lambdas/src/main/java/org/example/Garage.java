package org.example;

import java.util.List;

public class Garage {
    private int id;
    private List<Vehicle> vehicles;

    public Garage(int id, List<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicle> getVehicules() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehicles=" + vehicles +
                '}';
    }
}
