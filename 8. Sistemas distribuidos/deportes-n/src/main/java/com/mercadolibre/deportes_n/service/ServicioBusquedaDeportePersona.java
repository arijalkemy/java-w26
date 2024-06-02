package com.mercadolibre.deportes_n.service;

import org.springframework.stereotype.Service;

import com.mercadolibre.deportes_n.dtos.DTOPersonaDeporte;
import com.mercadolibre.deportes_n.model.Deporte;
import com.mercadolibre.deportes_n.model.DeportePersona;
import com.mercadolibre.deportes_n.model.Persona;
import com.mercadolibre.deportes_n.repository.RepositorioDeportePersona;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioBusquedaDeportePersona {

    public List<DTOPersonaDeporte> buscarDeportePersona()
    {
        List<DTOPersonaDeporte> personasDeportes = new ArrayList<>();

        for (DeportePersona deportePersona: RepositorioDeportePersona.getInstance().getAll()) {
            Persona persona = deportePersona.getPersona();
            Deporte deporte = deportePersona.getDeporte();
            personasDeportes.add(new DTOPersonaDeporte(persona.getNombre(), persona.getApellido(), deporte.getNombre()));
        }

        return  personasDeportes;
    }
}
