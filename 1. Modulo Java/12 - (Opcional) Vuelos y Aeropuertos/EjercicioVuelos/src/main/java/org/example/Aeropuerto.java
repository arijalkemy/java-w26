package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aeropuerto {
    String nombre;
    String ciudad;
    List<Tramo> vuelosOrigen;
    List<Tramo> vuelosDestino;


    public Aeropuerto(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        vuelosOrigen = new ArrayList<>();
        vuelosDestino = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void agregarVuelosOrigen(Tramo ... vuelos){
        vuelosOrigen.addAll( Arrays.stream(vuelos).toList() );
    }

    public void agregarVuelosDestino( Tramo ... vuelos){
        vuelosDestino.addAll( Arrays.stream(vuelos).toList() );
    }

    public int cantidadVuelosOrigen( int dia, int mes){

        return (int) vuelosOrigen.stream().filter(x -> x.getDia() == dia && x.getMes() == mes ).count();
    }

    public int cantidadVuelosDestino(int dia, int mes){
        return (int) vuelosDestino.stream().filter(x -> x.getDia() == dia && x.getMes() == mes ).count();
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
