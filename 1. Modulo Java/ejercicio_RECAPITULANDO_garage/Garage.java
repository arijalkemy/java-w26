import java.util.List;
import java.util.ArrayList;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;


    public Garage(int id){
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo (Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo (Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }

}
