import java.util.ArrayList;
import java.util.List;

public class Garage {
    private Integer Id;
    private List<Vehiculo> vehiculos;

    public Garage(Integer id, List<Vehiculo> vehiculos) {
        this.Id = id;
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "Id=" + Id +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
