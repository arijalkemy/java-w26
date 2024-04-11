package meli.bootcamp;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Garage garage = obtenerGarageConAutos();

    List<Vehiculo> vehiculosOrdenadosPorMarca = garage.obtenerVehiculosOrdenadosPorMarca();
    System.out.println("Vehiculos ordenados por marca:");
    vehiculosOrdenadosPorMarca.forEach(v -> System.out.println(v.toString()));

    List<Vehiculo> vehiculosOrdenadosPorCosto = garage.obtenerVehiculosOrdenadosPorCosto();
    System.out.println("\nVehiculos ordenados por costo:");
    vehiculosOrdenadosPorCosto.forEach(v -> System.out.println(v.toString()));

    List<Vehiculo> vehiculosOrdenadosPorMarcaYCosto = garage.obtenerVehiculosOrdenadosPorMarcaYCosto();
    System.out.println("\nVehiculos ordenados por marca y costo:");
    vehiculosOrdenadosPorMarcaYCosto.forEach(v -> System.out.println(v.toString()));

    List<Vehiculo> vehiculosConPrecioMenorA1000 = garage.obtenerVehiculosConPrecioMenorA(1000);
    System.out.println("\nVehiculos con precio menor a 1000:");
    vehiculosConPrecioMenorA1000.forEach(v -> System.out.println(v.toString()));

    List<Vehiculo> vehiculosConPrecioMayorOIgualA1000 = garage.obtenerVehiculosConPrecioMayorOIgualA(1000);
    System.out.println("\nVehiculos con precio mayor o igual a 1000:");
    vehiculosConPrecioMayorOIgualA1000.forEach(v -> System.out.println(v.toString()));

    double promedioDePrecios = garage.obtenerPromedioDePrecios();
    System.out.println("\nPromedio de precios: " + promedioDePrecios);
  }

  public static Garage obtenerGarageConAutos() {
    Garage garage = new Garage();

    Vehiculo fiesta = new Vehiculo("Ford", "Fiesta", 1000);
    Vehiculo explorer = new Vehiculo("Ford", "Explorer", 2500);
    Vehiculo focus = new Vehiculo("Ford", "Focus", 1200);

    Vehiculo cronos = new Vehiculo("Fiat", "Cronos", 1000);
    Vehiculo uno = new Vehiculo("Fiat", "Uno", 500);
    Vehiculo torino = new Vehiculo("Fiat", "Torino", 1250);

    Vehiculo spin = new Vehiculo("Chevrolet", "Spin", 2500);
    Vehiculo aveo = new Vehiculo("Chevrolet", "Aveo", 1250);

    Vehiculo fortuner = new Vehiculo("Toyota", "Fortuner", 3000);
    Vehiculo corola = new Vehiculo("Toyota", "Corola", 1200);

    Vehiculo logan = new Vehiculo("Renault", "Logan", 950);

    garage.agregarVehiculo(fiesta);
    garage.agregarVehiculo(focus);
    garage.agregarVehiculo(explorer);
    garage.agregarVehiculo(uno);
    garage.agregarVehiculo(cronos);
    garage.agregarVehiculo(torino);
    garage.agregarVehiculo(aveo);
    garage.agregarVehiculo(spin);
    garage.agregarVehiculo(corola);
    garage.agregarVehiculo(fortuner);
    garage.agregarVehiculo(logan);

    return garage;
  }

}