package com.w26.deportista.deportistas.servicio;

import com.w26.deportista.deportistas.dto.DTOPersonaDeporte;
import com.w26.deportista.deportistas.modelo.Deporte;
import com.w26.deportista.deportistas.modelo.DeportePersona;
import com.w26.deportista.deportistas.modelo.Persona;
import com.w26.deportista.deportistas.repositorio.RepositorioDeportePersona;
import org.springframework.stereotype.Service;

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
