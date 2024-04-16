package Dakar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private HashSet<Vehiculo> listaVehiculos = new HashSet<>(); //conjunto de vehículos que participarán de la carrera
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }
   // Una carrera además tiene un conjunto de vehículos que participarán de la misma.
   // Entonces, ahora la carrera va a tener la responsabilidad de poder agregar a un vehículo,
   // por lo que debemos definir los siguientes métodos:
    // public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);
    // public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente);
    // Ambos métodos agregan un vehículo siempre y cuando haya cupo.

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas){
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas){
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas));
        }
    }

    //También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:
    //public void eliminarVehiculo(vehículo);
    // public void eliminarVehiculoConPatente(String unaPatente);

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getPatente().equals(unaPatente)){
                listaVehiculos.remove(vehiculo);
                break;
            }
        }
    }

    //6. Queremos poder definir el ganador de una carrera:
    //El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
    //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)

    public Vehiculo definirGanador(){
        Vehiculo ganador = null;
        double max = 0;
        for (Vehiculo vehiculo : listaVehiculos){
            double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (valor > max){
                max = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    //Agregar a la carrera la responsabilidad de socorrer una moto y un auto:
    //public void socorrerAuto(String patente);
    // public void socorrerMoto(String patente);

    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getPatente().equals(patente)){
                socorristaAuto.socorrer((Auto) vehiculo);
                break;
            }
        }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getPatente().equals(patente)){
                socorristaMoto.socorrer((Moto) vehiculo);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000, 100000, "Dakar", 5);

        carrera.darDeAltaAuto(100, 10, 5, "ABC123", 1000, 4);
        carrera.darDeAltaAuto(120, 12, 6, "DEF456", 1200, 4);
        carrera.darDeAltaMoto(150, 15, 7, "GHI789", 800, 2);
        carrera.darDeAltaMoto(130, 13, 6, "JKL012", 900, 2);
        carrera.darDeAltaMoto(140, 14, 7, "MNO345", 1000, 2);
        carrera.eliminarVehiculoConPatente("DEF456");
        carrera.eliminarVehiculoConPatente("JKL012");

        System.out.println(carrera.definirGanador().getPatente());

        carrera.socorristaAuto = new SocorristaAuto();
        carrera.socorristaMoto = new SocorristaMoto();
        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("GHI789");
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }


}
