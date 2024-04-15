import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private long premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private socorristaAuto socorristaAuto;
    private socorristaMoto socorristaMoto;

    public Carrera(double distancia, long premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaDeVehiculos.size() <= cantidadDeVehiculosPermitidos)
            listaDeVehiculos.add(new Carro(velocidad,aceleracion,anguloDeGiro,patente));
    }
    public void darDeAltaMoto(double velocidad, double aceleracion,double anguloDeGiro, String patente){
        if(listaDeVehiculos.size() <= cantidadDeVehiculosPermitidos)
            listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }
    public String determinarGanador(){
        return listaDeVehiculos.stream().max(Comparator.comparing(vehiculo -> vehiculo.getVelocidad()*(vehiculo.getAceleracion()/2)/(vehiculo.getAnguloDeGiro())*(vehiculo.getPeso()-vehiculo.getNumeroDeRuedas()*100))).get().toString();
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }
    public void socorrerAuto(String patente){
        socorristaAuto.socorrer(listaDeVehiculos.stream().findAny());
    }
}
