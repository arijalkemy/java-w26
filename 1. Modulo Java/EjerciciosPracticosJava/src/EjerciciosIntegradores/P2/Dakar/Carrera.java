package EjerciciosIntegradores.P2.Dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private Socorrista socorrista;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorrista = new Socorrista();
    }

    public void darDeAltaVehiculo(Vehiculo auto) {
        if(cantidadDeVehiculosPermitidos>0){
            listaVehiculos.add(auto);
            this.cantidadDeVehiculosPermitidos--;
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getPatente().equals(patente)){
                eliminarVehiculo(vehiculo);
                return;
            }
        }
    }

    public void ganadorCarrera(){
        double max=-1;
        Vehiculo vehiculoGanador = null;
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getVelocidad()>max){
                max = vehiculo.getValorMax();
                vehiculoGanador = vehiculo;
            }
        }
        System.out.println("El ganador de la carrera es el vehiculo: "+vehiculoGanador);
    }

    public void socorrer(Vehiculo vehiculo){
        this.socorrista.socorrerVehiculo(vehiculo.getPatente(), vehiculo.getTipoVehiculo().getTipo());
    }
}
