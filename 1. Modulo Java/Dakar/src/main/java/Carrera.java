import java.util.*;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.cantidadDeVehiculosPermitidos > this.vehiculos.size()) {
            this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.cantidadDeVehiculosPermitidos > this.vehiculos.size()) {
            this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Optional<Vehiculo> vehiculo = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();
        if (vehiculo.isPresent()) {
            eliminarVehiculo(vehiculo.get());
        }
    }

    public Vehiculo obtenerGanador() {
        return Collections.max(vehiculos, Comparator.comparingInt(v -> (int) v.calcularMaximo()));
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorristaAuto((Auto) obtenerVehiculo(patente));
    }

    public void socorrerMoto(String patente) {
        socorristaMoto.socorristaMoto((Moto) obtenerVehiculo(patente));
    }

    public Vehiculo obtenerVehiculo(String patente) {
        return this.vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
    }

}
