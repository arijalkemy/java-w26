package com.w26.deportista.deportistas.repositorio;

import com.w26.deportista.deportistas.modelo.Persona;

import java.util.ArrayList;
import java.util.List;
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
