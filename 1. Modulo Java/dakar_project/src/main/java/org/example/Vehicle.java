package org.example;

public class Vehicle {
    private int velocity;
    private int acceleration;
    private int turningAngle;
    private String plate;

    private int weight;
    private int tires;

    public Vehicle(int velocity, int acceleration, int turningAngle, String plate, int weight) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.plate = plate;
        this.weight = weight;
    }

    public double getPerformance() {
        return (double) (velocity * (acceleration / 2)) / (turningAngle* (weight - tires * 100));
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getTurningAngle() {
        return turningAngle;
    }

    public void setTurningAngle(int turningAngle) {
        this.turningAngle = turningAngle;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTires() {
        return tires;
    }

    public void setTires(int tires) {
        this.tires = tires;
    }
}
