package socorristas;

import org.example.VehicleType;
import org.example.Vehiculo;

public class Socorrista {

    public void socorrer(Vehiculo vehiculo){

        if (vehiculo.getTipoVehiculo().equals(VehicleType.AUTO)){
            System.out.println("Socorriendo Auto");
        }else if(vehiculo.getTipoVehiculo().equals(VehicleType.MOTO)){
            System.out.println("Socorriendo Moto");
        }

    }
}
