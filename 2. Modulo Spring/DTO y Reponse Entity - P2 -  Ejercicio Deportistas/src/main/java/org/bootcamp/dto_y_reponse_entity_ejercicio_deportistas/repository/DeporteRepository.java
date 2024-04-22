package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.repository;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository implements IDeporteRepository{
    private List<Deporte> listaDeportes = new ArrayList<>();

    public DeporteRepository() {
        listaDeportes = llenarListaDeporte();
    }

    @Override
    public List<Deporte> obtenerDeportes() {
        return listaDeportes;
    }

    private List<Deporte> llenarListaDeporte() {
        List<Deporte> deportes = new ArrayList<>();

        deportes.add(new Deporte("Futbol", 2));
        deportes.add(new Deporte("Basketball", 4));
        deportes.add(new Deporte("Voleyball", 6));

        return deportes;
    }
}
