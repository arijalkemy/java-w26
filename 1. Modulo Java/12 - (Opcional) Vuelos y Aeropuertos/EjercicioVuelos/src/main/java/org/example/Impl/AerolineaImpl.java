package org.example.Impl;

import org.example.Aeropuerto;
import org.example.Tramo;
import org.example.Vuelo;

import java.util.*;

public class AerolineaImpl implements Crud<Vuelo>{
    List<Vuelo> vuelos;

    public AerolineaImpl() {
        this.vuelos = new ArrayList<>();
    }

    @Override
    public void altas(String fecha, Vuelo... vuelos) {
        List<Vuelo> nuevosVuelos = Arrays.stream(vuelos).toList();
        this.vuelos.addAll(nuevosVuelos);

        nuevosVuelos.forEach(v -> agregarTramosAeropuerto(fecha, v.getTramos()));

    }

    @Override
    public List<Vuelo> consulta() {
        return null;
    }

    public Aeropuerto menosEscalas(){
        return null;
    }

    private void agregarTramosAeropuerto( String fecha, List<Tramo> tramos){
        tramos.forEach( t -> {
            Aeropuerto origen = t.getAeropuertoOrigen();
            origen.agregarVuelosOrigen(fecha, t);

            Aeropuerto destino = t.getGetAeropuertoDestino();
            destino.agregarVuelosDestino(fecha, t);
        });
    }
}
