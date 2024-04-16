package repositorios;

import modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositorioVuelos {

    List<Vuelo> vuelos = new ArrayList<>();

    private static RepositorioVuelos instancia = null;

    private RepositorioVuelos(){

    }

    public static RepositorioVuelos obtenerInstancia(){
        if (instancia == null) {
            instancia = new RepositorioVuelos();
        }
        return instancia;
    }

    public List<Vuelo> obtenerVuelos(){
        return this.vuelos;
    }

    public void agregarVuelo(Vuelo vuelo) {
        this.vuelos.add(vuelo);
    }



}
