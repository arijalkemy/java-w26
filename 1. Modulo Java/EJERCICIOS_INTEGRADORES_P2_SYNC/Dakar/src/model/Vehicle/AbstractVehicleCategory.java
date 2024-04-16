package model.Vehicle;

public abstract class AbstractVehicleCategory {
    private final double weight;
    private final int wheels;

    public AbstractVehicleCategory(double weight, int wheels) {
        this.weight = weight;
        this.wheels = wheels;
    }
    public double getWeight() {
        return weight;
    }
    
    public int getWheels() {
        return wheels;
    }
}
