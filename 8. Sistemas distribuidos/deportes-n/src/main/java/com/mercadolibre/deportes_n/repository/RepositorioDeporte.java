package com.mercadolibre.deportes_n.repository;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.deportes_n.model.Deporte;

public class RepositorioDeporte extends AbstractRepositorio<List<Deporte>, Deporte> implements Cargable {

    private static RepositorioDeporte repositorio;

    private RepositorioDeporte() {
        super(new ArrayList<>());
    }

    @Override
    public void load() {
        repositorio.add(new Deporte("Futbol", Deporte.NIVELES.BASICO));
        repositorio.add(new Deporte("Futbol", Deporte.NIVELES.MEDIO));
        repositorio.add(new Deporte("Futbol", Deporte.NIVELES.AVANZADO));
        repositorio.add(new Deporte("Baloncesto", Deporte.NIVELES.BASICO));
        repositorio.add(new Deporte("Baloncesto", Deporte.NIVELES.MEDIO));
        repositorio.add(new Deporte("Baloncesto", Deporte.NIVELES.AVANZADO));

    }

    public static RepositorioDeporte getInstance(){
        if (repositorio == null)
        {
            RepositorioDeporte.repositorio = new RepositorioDeporte();
        }

        return repositorio;
    }
}
