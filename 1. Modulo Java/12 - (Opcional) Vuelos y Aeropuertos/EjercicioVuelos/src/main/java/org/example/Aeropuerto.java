package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Aeropuerto {
    String nombre;
    String ciudad;
    HashMap<String, List<Tramo>> vuelosOrigen;
    HashMap<String, List<Tramo>> vuelosDestino;


    public Aeropuerto(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        vuelosOrigen = new HashMap<>();
        vuelosDestino = new HashMap<>();

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

    public void agregarVuelosOrigen( String fecha, Tramo ... vuelos){
        List<Tramo> vuelosOrigen = this.vuelosOrigen.get(fecha);
        if( vuelosOrigen == null ){
            this.vuelosOrigen.put( fecha, Arrays.stream(vuelos).toList());
        }else{
            vuelosOrigen.addAll(
                    Arrays.stream(vuelos).toList()
            );
            this.vuelosOrigen.put(fecha, vuelosOrigen);
        }
    }

    public void agregarVuelosDestino( String fecha, Tramo ... vuelos){
        List<Tramo> vuelosDestino = this.vuelosDestino.get(fecha);
        if( vuelosDestino == null ){
            this.vuelosDestino.put( fecha, Arrays.stream(vuelos).toList());
        }else{
            vuelosDestino.addAll(
                    Arrays.stream(vuelos).toList()
            );
            this.vuelosDestino.put(fecha, vuelosDestino);
        }
    }

    public int cantidadVuelosOrigen(String fecha){
        List<Tramo> vuelos = vuelosOrigen.get(fecha);
        if( vuelos == null ){
            System.out.println("No se encontraron vuelos en el día");
            return 0;
        }
        return vuelos.size();
    }

    public int cantidadVuelosDestino(String fecha){
        List<Tramo> vuelos = vuelosDestino.get(fecha);
        if( vuelos == null ){
            System.out.println("No se encontraron vuelos en el día");
            return 0;
        }
        return vuelos.size();
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
