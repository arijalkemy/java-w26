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
    public void altas(Vuelo... vuelos) {
        List<Vuelo> nuevosVuelos = Arrays.stream(vuelos).toList();
        this.vuelos.addAll(nuevosVuelos);

        nuevosVuelos.forEach(v -> agregarTramosAeropuerto(v.getTramos()));

    }

    @Override
    public List<Vuelo> consulta() {
        return null;
    }

    public Aeropuerto menosEscalas(){
        return null;
    }

    private void agregarTramosAeropuerto(List<Tramo> tramos){
        tramos.forEach( t -> {
            Aeropuerto origen = t.getAeropuertoOrigen();
            origen.agregarVuelosOrigen( t);

            Aeropuerto destino = t.getGetAeropuertoDestino();
            destino.agregarVuelosDestino(t);
        });
    }
}
