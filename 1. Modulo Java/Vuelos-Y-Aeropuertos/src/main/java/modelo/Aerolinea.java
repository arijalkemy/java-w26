package modelo;

import java.util.ArrayList;
import java.util.List;

public class Aerolinea {
    private String nombre;
    private List<Vuelo> vuelos = new ArrayList<>();

    public Aerolinea(String nombre) {
        this.nombre = nombre;
    }

    public void agregarVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    @Override
    public String toString() {
        return "Aerolinea{" +
                "nombre='" + nombre + '\'' +
                ", vuelos=" + vuelos.toString() +
                '}';
    }
}
