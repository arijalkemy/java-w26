package meli.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Garage {
  long id;
  List<Vehiculo> vehiculos;

  public Garage(long id) {
    this.id = id;
    this.vehiculos = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void setVehiculos(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }
}
