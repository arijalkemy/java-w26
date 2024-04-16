package model.Vehicle;

public class MotorbikeCategory extends AbstractVehicleCategory {
    private static MotorbikeCategory category;

    public MotorbikeCategory(){
        super(300, 2);
    }

    public static MotorbikeCategory getInstance()
    {
        if (category == null) {
            category = new MotorbikeCategory();
        }

        return category;
    }

}
