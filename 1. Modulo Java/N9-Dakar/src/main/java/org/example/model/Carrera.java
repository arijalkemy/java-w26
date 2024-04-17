package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Integer distancia;
    private Double premio;
    private String nombre;
    private Integer cantDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(Integer distancia, Double premio, String nombre, Integer cantDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantDeVehiculosPermitidos = cantDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }


    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.vehiculos.size()<cantDeVehiculosPermitidos){
            Vehiculo auto = new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
            vehiculos.add(auto);
        } else{
            System.out.println("No hay cupo para agregar más vehículos.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.vehiculos.size() < cantDeVehiculosPermitidos) {
            Vehiculo moto = new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
            vehiculos.add(moto);
        } else {
            System.out.println("No hay cupo para agregar más vehículos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        for (Vehiculo vehiculo : this.vehiculos) {
            if (vehiculo.getPatente().equals(unaPatente)) {
                this.vehiculos.remove(vehiculo);
                break;
            }
        }
    }

    public Vehiculo definirGanador() {
        Vehiculo ganador = null;
        double maxValor = Double.MIN_VALUE;
        for (Vehiculo vehiculo : this.vehiculos) {
            double valor = vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion()) / (vehiculo.getAnguloDeGiro() *
                    (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : this.vehiculos) {
            if (vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                break;
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : this.vehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                break;
            }
        }
    }

    public String mostrarVehiculos() {
        StringBuilder vehiculosInfo = new StringBuilder();
        this.vehiculos.forEach(vehiculo ->
                vehiculosInfo.append("Patente: ").append(vehiculo.getPatente()).append(", Velocidad: ").append(vehiculo.getVelocidad()).append("\n")
        );
        return vehiculosInfo.toString();
    }

    public String obtenerGanador() {
        Vehiculo ganador = this.definirGanador();
        if (ganador != null) {
            return "El ganador de la carrera es el vehículo con patente: " + ganador.getPatente();
        } else {
            return "No hay ganador definido aún.";
        }
    }
}

