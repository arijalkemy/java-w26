import java.util.UUID;
import java.util.List;
import java.util.LinkedList;

public class Garaje {
    private UUID id;
    private List<Vehiculo> vehiculos;

    public Garaje()
    {
        this.id = UUID.randomUUID();
        System.out.println("Garage creado con el id: " + this.id.toString());
        this.vehiculos = new LinkedList<>();
    }

    public void agregarVehiculo(String modelo, String marca, float costo)
    {
        Vehiculo nuevo_vehiculo = new Vehiculo(modelo, marca, costo);
        this.vehiculos.add(nuevo_vehiculo);
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    

}
