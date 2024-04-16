package model.Vehicle;

public class CarCategory extends AbstractVehicleCategory {

    private static CarCategory category;
    public CarCategory(){
        super(1000, 4);
    }

    public static CarCategory getInstance()
    {
        if (category == null) {
            category = new CarCategory();
        }

        return category;
    }
}
