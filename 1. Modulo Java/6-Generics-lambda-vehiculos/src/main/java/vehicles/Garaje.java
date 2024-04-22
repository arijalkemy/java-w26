package vehicles;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    private List vehiculos = new ArrayList<Vehiculo>();

    public Garaje(int id, List vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List vehiculos) {
        this.vehiculos = vehiculos;
    }
}
