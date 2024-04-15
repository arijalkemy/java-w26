package com.example.model;

import java.util.List;

public class Race {
    private double distance;
    private double prize;
    private String name;
    private int numberOfVehiclesAllowed;
    private List<Vehicle> vehicleList;

    public Race() {

    }

    public Race(double distance, double prize, String name, int numberOfVehiclesAllowed, List<Vehicle> vehicleList) {
        this.distance = distance;
        this.prize = prize;
        this.name = name;
        this.numberOfVehiclesAllowed = numberOfVehiclesAllowed;
        this.vehicleList = vehicleList;
    }

    /*
     * Método para dar de alta a un vehículo
     */

    public void registerVehicle(Vehicle vehicleToRegister) {
        boolean vehicleAvailableToAdd = true;

        if (raceAvailable()) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getName().equals(vehicleToRegister.getName())) {
                    System.out.println("El vehículo ya está participando, no se puede añadir de nuevo.");
                    vehicleAvailableToAdd = false;
                }
            }

            if (vehicleAvailableToAdd) {
                vehicleList.add(vehicleToRegister);
                System.out.println("Vehículo " + vehicleToRegister.getName() + " añadido!");
            }

        } else {
            System.out.println("No hay plaza para registrar tu vehículo noob");
        }

    }

    /*
     * Método para validar no exceder el límite de vehículos
     */
    public Boolean raceAvailable() {
        return numberOfVehiclesAllowed > vehicleList.size();
    }

    public void deleteVehicle(Vehicle vehicleToDelete) {
        vehicleList.remove(vehicleToDelete);
        System.out.println("Vehículo " + vehicleToDelete.getName() + " ha sido deleteado!");
    }

    public void deleteVehicle(String vehicleName) {
        boolean canDelete = false;
        Vehicle vehicleToDelete = new Vehicle();
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getName().equals(vehicleName)) {
                vehicleToDelete = vehicle;
                canDelete = true;
            }
        }

        if (canDelete) {
            deleteVehicle(vehicleToDelete);
        } else {
            System.out.println("No existe ese vehículo para eliminar crack");
        }
    }

    public void winner(List<Vehicle> vehiclesRacing) {
        double currentWinner = 0;
        double comparator = 0;
        String winnerName = "";

        for (Vehicle vehicle : vehiclesRacing) {
            comparator = (vehicle.getSpeed()) * (0.5 * vehicle.getAcceleration())
                    / ((vehicle.getTurningAngle()) * (vehicle.getWeight() - (vehicle.getNumberOfWheels() * 100)));
            if (comparator > currentWinner) {
                currentWinner = comparator;
                winnerName = vehicle.getType() + " - " + vehicle.getName();
            }
        }

        System.out.println("El ganador ha sido " + winnerName + "! Con un valor calculado de: " + currentWinner);

    }

    public void helpVehicle(Vehicle vehicle) {
        System.out.println("Socorriendo " + vehicle.getType() + " ..." + "\n" +
                "con la patente: " + vehicle.getName());
    }

    public void helpVehicle(String vehicleNameToHelp) {
        boolean canHelp = false;
        Vehicle vehicleToHelp = new Vehicle();

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getName().equals(vehicleNameToHelp)) {
                canHelp = true;
                vehicleToHelp = vehicle;
            }
        }

        if (canHelp) {
            helpVehicle(vehicleToHelp);
        } else {
            System.out.println("No se puede socorrer a ese vehículo");
        }

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfVehiclesAllowed() {
        return numberOfVehiclesAllowed;
    }

    public void setNumberOfVehiclesAllowed(int numberOfVehiclesAllowed) {
        this.numberOfVehiclesAllowed = numberOfVehiclesAllowed;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
