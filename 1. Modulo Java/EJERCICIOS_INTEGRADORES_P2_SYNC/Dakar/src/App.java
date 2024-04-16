import model.Race.Race;
import model.Race.RaceManager;
import model.Vehicle.CategoryVehicle;
import model.Vehicle.Vehicle;
import model.Vehicle.VehicleManager;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Race carrera = new Race(100, 5000, 10);



        VehicleManager.registerVehicle(carrera, Vehicle.of(80, 340, 30, "pff92f", CategoryVehicle.CAR));
        VehicleManager.registerVehicle(carrera, Vehicle.of(100, 30, 90,"CHD966", CategoryVehicle.CAR));
        VehicleManager.registerVehicle(carrera, Vehicle.of(80, 500, 45, "SQL053", CategoryVehicle.MOTORBIKE));
        
        Vehicle vehicleWinner = RaceManager.getWinner(carrera);
        System.out.println("El vehiculo ganador es: " + vehicleWinner.getPatent());
    
        RaceManager.socorrerVehicle(carrera, "SQL053");
        RaceManager.socorrerVehicle(carrera, "CHD966");
        RaceManager.socorrerVehicle(carrera, "CHD96");
    }
}
