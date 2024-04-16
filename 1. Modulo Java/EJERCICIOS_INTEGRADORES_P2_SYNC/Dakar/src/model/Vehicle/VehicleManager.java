package model.Vehicle;

import model.Race.Race;

public interface VehicleManager {

    /**
     * Allow register car and motorbike
     * @param race
     * @param carToRegister
     */
    public static void registerVehicle(Race race, Vehicle carToRegister)
    {
        race.getCars().add(carToRegister);
    }

    public static void removeVehicle(Race race, Vehicle vehicle){
        race.getCars().remove(vehicle);
    }
    public static void removeVehicle(Race race, String patent){
        for (Vehicle iterable_element : race.getCars()) {
            if (iterable_element.getPatent().equals(patent)) {
                race.getCars().remove(iterable_element);
                return;
            }
        }
    }
}
