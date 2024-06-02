package com.mercadolibre.deportes_n.repository;


import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.deportes_n.model.Persona;
public class RepositorioPersona extends AbstractRepositorio<List<Persona>, Persona> implements Cargable {

    private static RepositorioPersona repositorio;

    public RepositorioPersona() {
        super(new ArrayList<Persona>());
    }

    public static RepositorioPersona getInstance()
    {
        if (repositorio == null)
            repositorio = new RepositorioPersona();
        return  repositorio;
    }

    @Override
    public void load() {
        repositorio.add(new Persona("Nilson", "Vargas", 22));
        repositorio.add(new Persona("Felipe", "Parra", 22));
    }
}
