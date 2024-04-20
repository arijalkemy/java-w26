package EjercicioVehiculos;

import java.util.HashMap;

public class VehiculoRepo {
    HashMap<Integer, Vehiculo> garage;

    public VehiculoRepo(HashMap<Integer, Vehiculo> garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "VehiculoRepo{" +
                "garage=" + garage.entrySet().stream().map(integerVehiculosEntry -> integerVehiculosEntry.toString()) +
                '}';
    }
}
