package org.example;

public class Motorcycle extends Vehicle {
    public Motorcycle(int velocity, int acceleration, int turningAngle, String plate) {
        super(velocity, acceleration, turningAngle, plate, 300);
    }
    public Motorcycle(int velocity, int acceleration, int turningAngle, String plate, int weight) {
        super(velocity, acceleration, turningAngle, plate, weight);
    }
}
