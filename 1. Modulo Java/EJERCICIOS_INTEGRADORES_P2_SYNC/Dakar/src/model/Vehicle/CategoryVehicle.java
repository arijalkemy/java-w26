package model.Vehicle;

public enum CategoryVehicle {
    CAR(CarCategory.getInstance()),
    MOTORBIKE(MotorbikeCategory.getInstance())
    ;

    private AbstractVehicleCategory categoryVehicle;

    private CategoryVehicle(AbstractVehicleCategory vehicle)
    {
        this.categoryVehicle = vehicle;
    }

    public AbstractVehicleCategory getCategoryVehicle() {
        return categoryVehicle;
    }

    public void setCategoryVehicle(AbstractVehicleCategory categoryVehicle) {
        this.categoryVehicle = categoryVehicle;
    }

    

}
