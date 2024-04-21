package org.example.repository;

import org.example.models.Aeropuerto;
import org.example.models.Ciudad;

import java.util.*;
import java.util.stream.Collectors;

public class AeropuertoRepository {
    private List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();

    public void agregarAeropuerto(Aeropuerto aeropuerto) {
        if (!aeropuertos.contains(aeropuerto)) {
            aeropuertos.add(aeropuerto);
            System.out.println("Aeropuerto agregado: " + aeropuerto);
            return;
        }
        System.out.println("El aeropuerto ya existe");
    }
    public int cantidadDeAeropuertosPorCiudad(Ciudad ciudad){
        return aeropuertos.stream().filter(x->x.getLocalizacion().equals(ciudad)).collect(Collectors.toList()).size();
    }

}
