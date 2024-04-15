package org.bootcamp;

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

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaVehiculos.add(vehiculo);
        } else {
            System.out.println("No se pueden agregar más vehiculos a la carrera.");
        }
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(auto);
            System.out.println("Auto agregado");
        } else {
            System.out.println("No hay cupo disponible para agregar un auto");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
            System.out.println("Moto agregada");
        } else {
            System.out.println("No hay cupo disponible para agregar una moto");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaVehiculos.contains(vehiculo)) {
            listaVehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado");
        } else {
            System.out.println("El vehículo no existe");
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculoAEliminar = null;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculoAEliminar = vehiculo;
                break;
            }
        }
        try {
            listaVehiculos.remove(vehiculoAEliminar);
            System.out.println("Vehiculo con patente " + patente + " eliminado de la carrera");
        } catch (Exception e) {
            System.out.println("No se encontró ningun vehiculo con la patente ");
        }
    }

    private double calcularPuntaje(Vehiculo vehiculo) {
        return vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public Vehiculo definirGanador() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos");
            return null;
        }

        Vehiculo ganador = listaVehiculos.get(0);
        double puntajeMaximo = calcularPuntaje(ganador);

        for (Vehiculo vehiculo : listaVehiculos) {
            double puntaje = calcularPuntaje(vehiculo);
            if (puntaje > puntajeMaximo) {
                ganador = vehiculo;
                puntajeMaximo = puntaje;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente) {
        boolean existe = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                existe = true;
            }
        }

        if (!existe) System.out.println("No se encontró ningún auto con la patente proporcionada.");
    }

    public void socorrerMoto(String patente) {
        boolean existe = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                existe = true;
            }
        }
        if (!existe)  System.out.println("No se encontró ninguna moto con la patente proporcionada.");
    }


    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }

}
