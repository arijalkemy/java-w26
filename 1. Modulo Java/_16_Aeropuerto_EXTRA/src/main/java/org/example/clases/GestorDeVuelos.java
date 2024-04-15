package org.example.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorDeVuelos {
    private List<Vuelo> vuelos;

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public GestorDeVuelos() {
        this.vuelos = new ArrayList<Vuelo>();
    }

    public void agregarVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }

    public int cantidadDeVuelosQueSalieronDelAeropuerto(Aeropuerto aeropuerto, Date fecha){
        int contadorDeSalidas=0;

        for (Vuelo vuelo: vuelos){
            if(vuelo.getAeropuertoOrigen().equals(aeropuerto) && vuelo.getFechaPartida().equals(fecha))
                contadorDeSalidas++;
        }

        return contadorDeSalidas;
    }

    public int cantidadDeVuelosQueLlegaronAlAeropuerto(Aeropuerto aeropuerto, Date fecha){
        int contadorDeLlegadas=0;

        for (Vuelo vuelo: vuelos){
            if(vuelo.getAeropuertoDestino().equals(aeropuerto) && vuelo.getFechaLlegada().equals(fecha))
                contadorDeLlegadas++;
        }

        return contadorDeLlegadas;
    }

    public Aeropuerto aeropuertoQueRecibioMenosVuelosEnEscalas(){

        Map<Aeropuerto, Long> llegadasConEscalasPorAeropuerto = vuelos.stream()
                .filter(vuelo -> vuelo.getEscalas().size()>=0)
                .collect(Collectors.groupingBy(Vuelo::getAeropuertoDestino, Collectors.counting()));

        return llegadasConEscalasPorAeropuerto.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public int obtenerCantidadDeVuelosDeUnPasajero(Persona persona){
        if(persona.getRol().getNombre().equals("Pasajero"))
            return (int)vuelos.stream().
                    filter(vuelo -> vuelo.cantidadDeBoletosDeUnaPersona(persona) > 0)
                    .distinct()
                    .count();
        return 0;
    }
}
