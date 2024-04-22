package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.dto.DeportistaDTO;

import java.util.List;

public interface IDeportistaService {
    public List<DeportistaDTO> encontrarDeportistas();
}
