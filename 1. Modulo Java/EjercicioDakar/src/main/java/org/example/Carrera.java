package org.example;

import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public boolean estaPermitido(){
        return cantidadDeVehiculosPermitidos>vehiculos.size();
    }
    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if (estaPermitido()){
            vehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Auto agregado correctamente");

        }else{
            System.out.println("No hay espacios");
        }

    }
    public void darDeAltaMoto(Double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if (estaPermitido()){
            vehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Moto agregada correctamente");

        }else{
            System.out.println("No hay espacios");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }
    public void definirGanador(){
        double max=0;
        Vehiculo ganador=null;
        for (Vehiculo vehiculo:vehiculos){
            double velocidad=vehiculo.getVelocidad()*(vehiculo.getAceleracion()/2)/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if (velocidad>max){
                max=velocidad;
                ganador=vehiculo;
            }
        }
        System.out.println("El ganador es: "+ganador.toString());
    }
    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo:vehiculos){
            if (vehiculo.getPatente().equals(patente)){
                socorristaAuto.socorrer((Auto) vehiculo);
            }
        }
    }
    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo:vehiculos){
            if (vehiculo.getPatente().equals(patente)){
                socorristaMoto.socorrer((Moto) vehiculo);
            }
        }
    }
}
