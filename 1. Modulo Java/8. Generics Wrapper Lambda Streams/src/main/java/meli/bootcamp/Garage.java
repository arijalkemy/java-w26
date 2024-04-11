package meli.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garage {
  List<Vehiculo> vehiculos;

  public Garage() {
    this.vehiculos = new ArrayList<>();
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void agregarVehiculo(Vehiculo vehiculo) {
    if(vehiculos.contains(vehiculo))
      throw new IllegalArgumentException("El vehiculo ya se encuentra en el garage");

    this.vehiculos.add(vehiculo);
  }

  List<Vehiculo> obtenerVehiculosOrdenadosPorMarca() {
    return vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca)).toList();
  }

  List<Vehiculo> obtenerVehiculosOrdenadosPorCosto() {
    return vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getCosto)).toList();
  }

  List<Vehiculo> obtenerVehiculosOrdenadosPorMarcaYCosto() {
    return vehiculos.stream().sorted(Vehiculo::compararPorMarcaYprecio).toList();
  }

  List<Vehiculo> obtenerVehiculosConPrecioMenorA(int precio) {
    return vehiculos.stream().filter(v -> v.getCosto() < precio).toList();
  }

  List<Vehiculo> obtenerVehiculosConPrecioMayorOIgualA(int precio) {
    return vehiculos.stream().filter(v -> v.getCosto() >= precio).toList();
  }

  double obtenerPromedioDePrecios() {
    return vehiculos.stream().mapToInt(Vehiculo::getCosto).average().orElse(0);
  }

}
