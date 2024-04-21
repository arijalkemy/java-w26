package org.example.repository;

import org.example.models.Aeropuerto;
import org.example.models.Ciudad;
import org.example.models.Vuelo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class VueloRepository {
    private List<Vuelo> vuelos = new ArrayList<Vuelo>();

    public VueloRepository() {

    }
    public int cantidadDeVuelosPorAeropuerto(Aeropuerto aeropuerto) {
        int cantidad = 0;
        cantidad = vuelos.stream().filter(x->x.getAeropuertoDeSalida().equals(aeropuerto)).collect(Collectors.toList()).size();
        return cantidad;
    }
    public int cantidadDePasajerosRecibidos(Aeropuerto aeropuerto) {

        int cantidad = vuelos.stream()
                .filter(x->x.getAeropuertoDeLlegada().equals(aeropuerto))
                .collect(Collectors.toList()).stream().
                mapToInt(x->x.getListadoDePasajeros().size()).
                sum();
        return cantidad;
    }
    public Aeropuerto aeropuertoConMenosEscalas(){
        Map<Aeropuerto,Integer> aeropuertosEscalas = new HashMap<Aeropuerto,Integer>();
        List<Aeropuerto> escalas = new ArrayList<Aeropuerto>();
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getEscalas().size()>0) {
                escalas=vuelo.getEscalas();
                for (Aeropuerto escala : escalas) {
                    if(aeropuertosEscalas.get(escala)==null){
                        aeropuertosEscalas.put(escala,1);
                    }
                    else {
                        aeropuertosEscalas.put(escala,aeropuertosEscalas.get(escala) + 1);
                    }
                }
            }
        }
        Map.Entry<Aeropuerto,Integer> aeropuerto = aeropuertosEscalas.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);
        return aeropuerto.getKey();
    }
    public Ciudad ciudadConMasPasajerosEnUnDia (LocalDate fecha){
        Ciudad ciudad = null;
        Map<Ciudad,Integer> ciudadesConPasajeros = new HashMap<>();
        List<Vuelo> vuelosEnUnDia = new ArrayList<Vuelo>();
        vuelosEnUnDia = vuelos.
    }

}
