package org.meli.clases;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    SocorristaAuto socorristaAuto = new SocorristaAuto();
    SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }
    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (this.vehiculos.size()<this.cantidadDeVehiculosPermitidos){
            this.vehiculos.add(new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 1000.0, 4));
        }else{
            System.out.println("No se pueden agregar mas vehiculos");
        }
    }
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (this.vehiculos.size()<this.cantidadDeVehiculosPermitidos){
            this.vehiculos.add(new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 300.0, 2));
        }else{
            System.out.println("No se pueden agregar mas vehiculos");
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        for (Vehiculo vehiculo : this.vehiculos){
            if (vehiculo.getPatente().equals(patente)){
                this.vehiculos.remove(vehiculo);
                break;
            }else{
                System.out.println("El vehiculo no se encuentra registrado");
            }
        }
    }

    public void imprimirParticipantes(){
        for (Vehiculo vehiculo : this.vehiculos){
            System.out.println("Vehiculo con patente: "+vehiculo.getPatente()+" de categoria: "+vehiculo.getCategoria());
        }
    }

    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo : this.vehiculos){
            if (vehiculo.getPatente().equals(patente)){
                this.socorristaAuto.socorrer(vehiculo);
                break;
            }
        }
    }
    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo : this.vehiculos){
            if (vehiculo.getPatente().equals(patente)){
                this.socorristaMoto.socorrer(vehiculo);
                break;
            }
        }
    }


}
