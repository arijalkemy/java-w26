package logica;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    //Atributos
    private Integer id;
    private List vehiculos;

    public Garaje(Integer id) {
        this.id = id;
        this.vehiculos = new ArrayList();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
}
