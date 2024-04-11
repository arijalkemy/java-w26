package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private String uid;
    private List<Vehicle> vehiclesList;

    public Garage(String uid, List<Vehicle> vehiclesList) {
        this.uid = uid;
        this.vehiclesList = vehiclesList;
    }

    // Get vehicles list sorted by price
    public List<Vehicle> getSortedByPrice() {
        return vehiclesList.stream().sorted(Comparator.comparing(Vehicle::getPrice)).collect(Collectors.toList());
    }

    // Get vehicles list sorted by brand and price
    public List<Vehicle> getSortedByPriceAndBrand() {
        return vehiclesList.stream()
                .sorted(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getPrice))
                .collect(Collectors.toList());
    }

    // Get vehicles list only with vehicles with price < 1000
    public List<Vehicle> getLessThan() {
        return vehiclesList.stream()
                .filter(vehicle -> vehicle.getPrice() < 1000)
                .collect(Collectors.toList());
    }
    // Get vehicles list only with vehicles with price >= 1000
    public List<Vehicle> getGreaterThan() {
        return vehiclesList.stream()
                .filter(vehicle -> vehicle.getPrice() >= 1000)
                .collect(Collectors.toList());
    }
    // Get average price of the vehicles list
    public String getAverageStr() {
        int result = this.vehiclesList
                .stream()
                .mapToInt(Vehicle::getPrice)
                .sum();
        return "The average for all the price is: " + result / this.vehiclesList.size();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    public void setVehiclesList(List<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }
}
