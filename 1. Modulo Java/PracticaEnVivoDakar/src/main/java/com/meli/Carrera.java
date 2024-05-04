package com.meli;

import java.util.Comparator;
import java.util.List;

/**
 * Representa una carrera con un conjunto de vehículos.
 */
public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    /**
     * Construye una nueva instancia de Carrera.
     *
     * @param distancia La distancia de la carrera.
     * @param premioEnDolares El premio en dólares de la carrera.
     * @param nombre El nombre de la carrera.
     * @param cantidadDeVehiculosPermitidos La cantidad máxima de vehículos permitidos en la carrera.
     * @param vehiculos La lista de vehículos en la carrera.
     */
    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene la distancia de la carrera.
     *
     * @return La distancia de la carrera.
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Establece la distancia de la carrera.
     *
     * @param distancia La nueva distancia de la carrera.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Obtiene el premio en dólares de la carrera.
     *
     * @return El premio en dólares de la carrera.
     */
    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    /**
     * Establece el premio en dólares de la carrera.
     *
     * @param premioEnDolares El nuevo premio en dólares de la carrera.
     */
    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    /**
     * Obtiene el nombre de la carrera.
     *
     * @return El nombre de la carrera.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la carrera.
     *
     * @param nombre El nuevo nombre de la carrera.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad máxima de vehículos permitidos en la carrera.
     *
     * @return La cantidad máxima de vehículos permitidos en la carrera.
     */
    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    /**
     * Establece la cantidad máxima de vehículos permitidos en la carrera.
     *
     * @param cantidadDeVehiculosPermitidos La nueva cantidad máxima de vehículos permitidos en la carrera.
     */
    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    /**
     * Obtiene la lista de vehículos en la carrera.
     *
     * @return La lista de vehículos en la carrera.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos en la carrera.
     *
     * @param vehiculos La nueva lista de vehículos en la carrera.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Registra un nuevo auto en la carrera.
     *
     * @param velocidad La velocidad del auto.
     * @param aceleracion La aceleración del auto.
     * @param anguloDeGiro El ángulo de giro del auto.
     * @param patente La patente del auto.
     */
    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            if (vehiculos.stream().noneMatch(vehiculo -> vehiculo instanceof Auto && vehiculo.getPatente().equals(patente))) {
                Auto vehiculo = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
                vehiculos.add(vehiculo);
                System.out.println("Se inscribio a "+ vehiculo.toString());
            } else {
                System.out.println("Ya existe un auto con la patente "+patente);
            }
        }
    }

    /**
     * Registra una nueva moto en la carrera.
     *
     * @param velocidad La velocidad de la moto.
     * @param aceleracion La aceleración de la moto.
     * @param anguloDeGiro El ángulo de giro de la moto.
     * @param patente La patente de la moto.
     */
    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            if (vehiculos.stream().noneMatch(vehiculo -> vehiculo instanceof Moto && vehiculo.getPatente().equals(patente))) {
                Moto vehiculo = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
                vehiculos.add(vehiculo);
                System.out.println("Se inscribio a "+ vehiculo.toString());
            } else {
                System.out.println("Ya existe una moto con la patente "+patente);
            }
        }
    }

    /**
     * Elimina un vehículo de la carrera.
     *
     * @param vehiculo El vehículo a eliminar.
     */
    public void eliminarVehiculo(Vehiculo vehiculo) {
        boolean status =  vehiculos.removeIf(vehiculo1 -> {
            if (vehiculo1.getPatente().equals(vehiculo.getPatente())) {
                System.out.println("Se eliminó el vehículo con patente " + vehiculo.getPatente());
                return true;
            } else {
                return false;
            }
        });

        if (!status) {
            System.out.println("No se encontró el vehículo con patente " + vehiculo.getPatente());
        }
    }

    /**
     * Elimina un vehículo de la carrera por su patente.
     *
     * @param patente La patente del vehículo a eliminar.
     */
    public void eliminarPorPaatente(String patente) {
        Vehiculo vehiculo = vehiculos.stream().filter(vehiculo1 -> vehiculo1.getPatente().equals(patente)).findFirst().orElse(null);
        if (vehiculo != null) {
            System.out.println("El vehiculo : " + vehiculo.toString() + " ha sido descalificado");
            vehiculos.remove(vehiculo);
        } else {
            System.out.println("No se encontro el vehiculo con la patente : " + patente);
        }
    }

    /**
     * Calcula el ganador de la carrera.
     *
     * @return El vehículo ganador.
     */
    public Vehiculo calcularGanador() {
        return vehiculos.stream()
                .max(Comparator.comparingDouble(vehiculo ->
                        vehiculo.getVelocidad() * ( 0.5 * vehiculo.getAceleracion()) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100))))
                .orElse(null);
    }

    /**
     * Imprime la lista de vehículos en la carrera.
     */
    public void imprimirlista() {
        vehiculos.forEach(Vehiculo::toString);
    }
}