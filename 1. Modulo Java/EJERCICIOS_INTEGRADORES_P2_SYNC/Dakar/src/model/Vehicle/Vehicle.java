package model.Vehicle;

public class Vehicle {
    private double velocity, acceleration, turningAngle;
    private String patent;
    private AbstractVehicleCategory category;
    public Vehicle() {
    }
    public Vehicle(double velocity, double acceleration, double turningAngle, String patent,
            AbstractVehicleCategory category) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.patent = patent;
        this.category = category;
    }

    public static Vehicle of(double velocity, double acceleration, double turningAngle, String patent,
            CategoryVehicle car)
    {
        return new Vehicle(velocity, acceleration, turningAngle, patent, car.getCategoryVehicle());
    }

    public double getVelocity() {
        return velocity;
    }
    public void setVelocity(double velocity) {
        this.velocity = velocity;
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
    public String getPatent() {
        return patent;
    }
    public void setPatent(String patent) {
        this.patent = patent;
    }
    public AbstractVehicleCategory getCategory() {
        return category;
    }
    public void setCategory(AbstractVehicleCategory category) {
        this.category = category;
    }
    
    
    
}
