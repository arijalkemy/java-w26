package classes;

import classes.socorristas.Socorrista;
import classes.socorristas.SocorristaAuto;
import classes.vehiculos.Auto;
import classes.vehiculos.Moto;
import classes.vehiculos.Vehiculo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;


    private List<Socorrista> socorristas;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos, List<Socorrista> socorristas) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristas = socorristas;
    }


    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(final String unaPatente) {
        Optional<Vehiculo> vehiculo = listaDeVehiculos.stream().filter(v -> v.getPatente().equals(unaPatente)).findFirst();
        if (vehiculo.isPresent()) {
            listaDeVehiculos.remove(vehiculo.get());
        } else {
            System.out.println("No se encontró el vehículo con patente " + unaPatente);
        }
    }

    public Vehiculo obtenerGanador() {
        Optional<Vehiculo> ganador = listaDeVehiculos.stream().max(Comparator.comparingDouble(v -> (v.getVelocidad() * v.getAceleracion()/2) / (v.getAnguloDeGiro()*(v.getPeso() - v.getRuedas() - 100))));
        return ganador.get();
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> auto = listaDeVehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst();

        if (auto.isPresent() && auto.get() instanceof Auto) {
            Vehiculo autoASocorrer = auto.get();
            for (Socorrista socorrista: this.socorristas){
                if (socorrista instanceof SocorristaAuto) {
                    socorrista.socorrer(autoASocorrer);
                }
            }
        } else {
            System.out.println("No se encontró el auto con patente " + patente);
        }
    }
}
