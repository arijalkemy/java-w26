package modelo;

import java.util.List;

public class Aerolinea {
    private String nombre;
    private List<Vuelo> vuelos;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
    }

    public void agregarVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }
}
