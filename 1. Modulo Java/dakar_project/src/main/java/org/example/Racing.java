package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Racing {
    private int distance;
    private int price;
    private String name;
    private int vehQuantity;
    private List<Vehicle> vehicleList;

    public Racing(int distance, int price, String name, int vehQuantity) {
        this.distance = distance;
        this.price = price;
        this.name = name;
        this.vehQuantity = vehQuantity;
        this.vehicleList = new ArrayList<>();
    }

    public void addVehicle(Vehicle newVehicle) {
        if (vehicleList.size() >= vehQuantity) {
            System.out.println("No hay mas cupos");
            return;
        }
        this.vehicleList.add(newVehicle);
    }

    public void deleteVehicle(Vehicle vehToDel) {
        this.vehicleList.remove(vehToDel);
    }

    public void deleteVehByPlate(String plateToDel) {
        this.vehicleList.removeIf(veh -> Objects.equals(veh.getPlate(), plateToDel));
    }

    public void help(Vehicle vehicle) {
        Lifeguard<Vehicle> lifeguard = new Lifeguard<>();
        lifeguard.help(vehicle);
    }
}
