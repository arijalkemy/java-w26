package genericsLambdaStreams;
import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private String id;
    private List<Vehiculo> vehiculos;

    public Garaje(String id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<genericsLambdaStreams.Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}