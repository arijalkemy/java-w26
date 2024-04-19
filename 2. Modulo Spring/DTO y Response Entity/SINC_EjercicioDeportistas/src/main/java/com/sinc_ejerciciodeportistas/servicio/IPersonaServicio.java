package com.sinc_ejerciciodeportistas.servicio;

import com.sinc_ejerciciodeportistas.dto.PersonaDeporteDTO;

import java.util.List;

public interface IPersonaServicio {
    List<PersonaDeporteDTO> obtenerTodasPersonasDeportistas();
}
