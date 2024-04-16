package model.Race;

import java.util.ArrayList;
import java.util.List;

import model.Vehicle.Vehicle;
import model.Vehicle.Helper.CarHelper;
import model.Vehicle.Helper.IHelperVehicle;
import model.Vehicle.Helper.MotobikeHelper;

public class Race {
    private double distance;
    private double prizeInDollars;
    private int allowVehicles;
    private List<Vehicle> cars;
    private IHelperVehicle helperMotorbike;
    private IHelperVehicle helperCar;

    public Race(double distance, double prizeInDollars, int allowVehicles) {
        this.distance = distance;
        this.prizeInDollars = prizeInDollars;
        this.allowVehicles = allowVehicles;
        this.cars = new ArrayList<>();
        this.helperCar = new CarHelper();
        this.helperMotorbike = new MotobikeHelper();
    }


    public double getDistance() {
        return distance;
    }


    public void setDistance(double distance) {
        this.distance = distance;
    }


    public double getPrizeInDollars() {
        return prizeInDollars;
    }


    public void setPrizeInDollars(double prizeInDollars) {
        this.prizeInDollars = prizeInDollars;
    }


    public int getAllowVehicles() {
        return allowVehicles;
    }


    public void setAllowVehicles(int allowVehicles) {
        this.allowVehicles = allowVehicles;
    }


    public List<Vehicle> getCars() {
        return cars;
    }


    public void setCars(List<Vehicle> cars) {
        this.cars = cars;
    }


    public IHelperVehicle getHelperMotorbike() {
        return helperMotorbike;
    }


    public void setHelperMotorbike(IHelperVehicle helperMotorbike) {
        this.helperMotorbike = helperMotorbike;
    }


    public IHelperVehicle getHelperCar() {
        return helperCar;
    }


    public void setHelperCar(IHelperVehicle helperCar) {
        this.helperCar = helperCar;
    }

        
}
