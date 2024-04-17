package com.w26.deportista.deportistas.repositorio;

import com.w26.deportista.deportistas.modelo.Deporte;
import com.w26.deportista.deportistas.modelo.DeportePersona;
import com.w26.deportista.deportistas.modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeportePersona extends AbstractRepositorio<List<DeportePersona>, DeportePersona> implements Cargable {
    private static RepositorioDeportePersona repositorio;

    private RepositorioDeportePersona() {
        super(new ArrayList<>());
    }

    public static RepositorioDeportePersona getInstance()
    {
        if (RepositorioDeportePersona.repositorio == null)
        {
            repositorio = new RepositorioDeportePersona();
        }
        return  repositorio;
    }

    @Override
    public void load() {
        List<Persona> personas = RepositorioPersona.getInstance().getAll();
        List<Deporte> deportes = RepositorioDeporte.getInstance().getAll();

        repositorio.add(new DeportePersona(personas.get(0), deportes.get(2)));
        repositorio.add(new DeportePersona(personas.get(0), deportes.get(4)));
    }
}
