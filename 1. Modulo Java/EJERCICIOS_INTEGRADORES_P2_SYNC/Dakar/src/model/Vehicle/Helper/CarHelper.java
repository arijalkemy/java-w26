package model.Vehicle.Helper;

import model.Vehicle.Vehicle;

public class CarHelper implements IHelperVehicle {

    @Override
    public void help(Vehicle vehicleToHelp) {
        System.out.println("Socorreindo auto, patente: " + vehicleToHelp.getPatent());
    }

    
}
