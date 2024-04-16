package org.example;

import org.example.socorristas.SocorristaAuto;
import org.example.socorristas.SocorristaMoto;
import org.example.vehiculos.Auto;
import org.example.vehiculos.Moto;
import org.example.vehiculos.Vehiculo;

import java.util.*;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    public List<SocorristaAuto> socorristasAutos;
    public List<SocorristaMoto> socorristasMotos;

    public Carrera() {
        this.vehiculos = new ArrayList<>();
        this.socorristasAutos = new ArrayList<>();
        this.socorristasMotos = new ArrayList<>();
    }

    public void agregarSocorristaMoto(SocorristaMoto ... socorristas) {
        Collections.addAll(this.socorristasMotos, socorristas);
    }

    public void agregarSocorristasAuto(SocorristaAuto ... socorristas) {
        Collections.addAll(this.socorristasAutos, socorristas);
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        this.vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
    }

    public Optional<Vehiculo> ganador() {
        return this.vehiculos.stream().max(Comparator.comparing(Vehiculo::valorObtenidoRendimiento));
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> posibleMoto = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();

        if(posibleMoto.isPresent()) {
            Optional<SocorristaMoto> posibleSocorrista = this.socorristasMotos.stream().findAny();

            if(posibleSocorrista.isPresent()) {
                SocorristaMoto socorristaMoto = posibleSocorrista.get();

                Moto moto = (Moto) posibleMoto.get();
                socorristaMoto.socorrer(moto);
            }
        }
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> posibleAuto = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();

        if(posibleAuto.isPresent()) {
            Optional<SocorristaAuto> posibleSocorrista = this.socorristasAutos.stream().findAny();

            if(posibleSocorrista.isPresent()) {
                SocorristaAuto socorristaAuto = posibleSocorrista.get();

                Auto auto = (Auto) posibleAuto.get();
                socorristaAuto.socorrer(auto);
            }
        }
    }
}
