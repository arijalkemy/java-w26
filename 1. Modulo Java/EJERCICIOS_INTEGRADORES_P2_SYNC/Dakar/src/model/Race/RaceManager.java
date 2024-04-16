package model.Race;
import model.Vehicle.CarCategory;
import model.Vehicle.MotorbikeCategory;
import model.Vehicle.Vehicle;

public interface RaceManager {
    public static Vehicle getWinner(Race race)
    {
        Object[] objsVehicles = race.getCars().toArray();
        Vehicle[] cars =  new Vehicle[objsVehicles.length];
        for (int i = 0; i < objsVehicles.length; i++) {
            cars[i] = (Vehicle) objsVehicles[i];
        }

        double bestKPI = RaceManager.calculateWinner(cars[0]);
        int winner = 0;


        for (int i = 1; i < cars.length; i++) {
            double kpi = RaceManager.calculateWinner(cars[i]);
            if (kpi > bestKPI ) {
                bestKPI = kpi;
                winner = i;
            }        
        }

        return cars[winner];
    }
    /**
     * Return kpi tha indicate winner 
     * @param vehicle
     * @return
     */
    private static double calculateWinner(Vehicle vehicle)
    {
        double kpi = Double.MIN_VALUE;

        double weight = vehicle.getCategory().getWeight();
        int wheels = vehicle.getCategory().getWheels();

        kpi = (vehicle.getVelocity() * 0.5 + vehicle.getAcceleration())/(vehicle.getTurningAngle() * (weight - (wheels*1000)));
        System.out.println("KPI CAL: " + kpi);
        return kpi;
    }

    public static void socorrerVehicle(Race race, String patent)
    {
        for (Vehicle vehicleToHelp : race.getCars()) {
            if (vehicleToHelp.getPatent().equals(patent)) {       
                if (vehicleToHelp.getCategory().getClass().equals(CarCategory.class)) {
                    race.getHelperCar().help(vehicleToHelp);
                }

                if (vehicleToHelp.getCategory().getClass().equals(MotorbikeCategory.class)) {
                    race.getHelperMotorbike().help(vehicleToHelp);
                }
                    
                return;
                }
                
            
        }
        System.out.println("Vehiculo no encontrado!!!");
    }

}
