package com.sinc_ejerciciodeportistas.servicio.implementacion;

import com.sinc_ejerciciodeportistas.dto.PersonaDeporteDTO;
import com.sinc_ejerciciodeportistas.entidades.Persona;
import com.sinc_ejerciciodeportistas.repositorio.Repositorio;
import com.sinc_ejerciciodeportistas.servicio.IPersonaServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonaServicioImpl implements IPersonaServicio {

    @Override
    public List<PersonaDeporteDTO> obtenerTodasPersonasDeportistas() {
        List<PersonaDeporteDTO> listaPersonaDeporteDTO = new ArrayList<>();

        for (Persona persona : Repositorio.listaPersonas) {
            if (persona.getDeporte() != null) {
                listaPersonaDeporteDTO.add(convertirAPersonaDeporteDTO(persona));
            }
        }
        return listaPersonaDeporteDTO;
    }

    public PersonaDeporteDTO convertirAPersonaDeporteDTO(Persona persona) {
        return new PersonaDeporteDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
    }
}
