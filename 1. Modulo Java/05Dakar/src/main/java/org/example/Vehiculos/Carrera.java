package org.example.Vehiculos;

import org.example.Socorristas.SocorristaAuto;
import org.example.Socorristas.SocorristaMoto;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private HashMap<String, Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public void darDeAlta(Vehiculo vehiculo) {
        if (this.cantidadDeVehiculosPermitidos == this.listaDeVehiculos.size()) {
            return;
        }
        this.listaDeVehiculos.put(vehiculo.getPatente(), vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.listaDeVehiculos.remove(vehiculo.getPatente());
    }

    public void eliminarVehiculoConPatente(String patente) {
        this.listaDeVehiculos.remove(patente);
    }

    public Optional<Vehiculo> determinarGanador() {
        return this.listaDeVehiculos.values().stream().max(Comparator.comparing(Vehiculo::obtenerCoeficiente));
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }
    
}
