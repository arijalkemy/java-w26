package com.example.model;

public class Vehicle {
    private String type;
    private double speed;
    private double acceleration;
    private double turningAngle;
    private double weight;
    private int numberOfWheels;
    private String name;

    public Vehicle(){

    }

    public Vehicle(String type, double speed, double acceleration, double turningAngle, double weight, int numberOfWheels, String name) {
        this.type = type;
        this.speed = speed;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.weight = weight;
        this.numberOfWheels = numberOfWheels;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getTurningAngle() {
        return turningAngle;
    }

    public void setTurningAngle(double turningAngle) {
        this.turningAngle = turningAngle;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    

}
