package com.deportista.ejerciciodeportistas.service;

import com.deportista.ejerciciodeportistas.models.Deporte;

import com.deportista.ejerciciodeportistas.models.dto.PersonaDTO;

import java.util.List;

public interface IDeportes {
    public String verDeportes();

    public Deporte chequearDeportes(String nombreDeporte);

    public List<PersonaDTO> verDeportistas();
}
