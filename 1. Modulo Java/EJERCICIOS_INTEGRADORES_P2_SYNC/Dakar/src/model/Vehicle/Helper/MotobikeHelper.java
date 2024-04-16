package model.Vehicle.Helper;

import model.Vehicle.Vehicle;

public class MotobikeHelper implements IHelperVehicle {

    @Override
    public void help(Vehicle vehicleToHelp) {
        System.out.println("Socorreindo moto, patente: " + vehicleToHelp.getPatent());
    } 
}
