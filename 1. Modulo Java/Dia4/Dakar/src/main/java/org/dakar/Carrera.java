package org.dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(patente);
            auto.setVelocidad(velocidad);
            auto.setAceleracion(aceleracion);
            auto.setAnguloDeGiro(anguloDeGiro);
            listaVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(patente);
            moto.setVelocidad(velocidad);
            moto.setAceleracion(aceleracion);
            moto.setAnguloDeGiro(anguloDeGiro);
            listaVehiculos.add(moto);
        }
    }

    /*
    Los dos métodos para dar de alta se pueden mejorar, ya que si agrego un nuevo parámetro a la clase
    del vehiculo tengo que hacer crecer los métodos. La responsabilidad de instanciar el vehiulo no
    debería ser de la clase Carrera. Esta solución no es escalable, pero lo pide el ejercicio.
     */

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        listaVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo definirGanador() {
        Vehiculo ganador = null;
        double maxValor = Double.MIN_VALUE;

        for (Vehiculo vehiculo : listaVehiculos) {
            double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                    (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));

            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                return;
            }
        }
        System.out.println("No se encontró un auto con esa patente en la carrera.");
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                return;
            }
        }
        System.out.println("No se encontró una moto con esa patente en la carrera.");
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

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}

