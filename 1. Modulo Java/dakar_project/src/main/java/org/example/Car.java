package org.example;

public class Car extends Vehicle {

    public Car(int velocity, int acceleration, int turningAngle, String plate) {
        super(velocity, acceleration, turningAngle, plate, 1000);
    }

    public Car(int velocity, int acceleration, int turningAngle, String plate, int weight) {
        super(velocity, acceleration, turningAngle, plate, weight);
    }
}
