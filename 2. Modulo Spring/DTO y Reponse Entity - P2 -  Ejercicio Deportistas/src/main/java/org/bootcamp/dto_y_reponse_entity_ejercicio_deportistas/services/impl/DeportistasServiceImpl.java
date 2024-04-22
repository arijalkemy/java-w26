package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services.impl;

import jakarta.annotation.PostConstruct;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.dto.DeportistaDTO;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Deporte;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Persona;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.repository.IDeporteRepository;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.repository.IPersonaRepository;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services.IDeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeportistasServiceImpl implements IDeportistaService {
    @Autowired
    IDeporteRepository deporteRepository;
    @Autowired
    IPersonaRepository personaRepository;

    private List<DeportistaDTO> deportistaDTOList = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Inicializamos las listas después de que las dependencias han sido inyectadas
        deportistaDTOList = llenarListaDeportistas();
    }

    @Override
    public List<DeportistaDTO> encontrarDeportistas() {
        return deportistaDTOList;
    }

    private List<DeportistaDTO> llenarListaDeportistas() {
        List<Persona> personasLista = personaRepository.obtenerPersonas();
        List<Deporte> deporteLista = deporteRepository.obtenerDeportes();

        DeportistaDTO d1 = new DeportistaDTO();
        DeportistaDTO d2 = new DeportistaDTO();
        DeportistaDTO d3 = new DeportistaDTO();
        DeportistaDTO d4 = new DeportistaDTO();

        d1.setNombrePersona(personasLista.get(0).getNombre());
        d1.setApellido(personasLista.get(0).getApellido());
        d1.setNombreDeporte(deporteLista.get(0).getNombre());

        d2.setNombrePersona(personasLista.get(1).getNombre());
        d2.setApellido(personasLista.get(1).getApellido());
        d2.setNombreDeporte(deporteLista.get(1).getNombre());

        d3.setNombrePersona(personasLista.get(2).getNombre());
        d3.setApellido(personasLista.get(2).getApellido());
        d3.setNombreDeporte(deporteLista.get(2).getNombre());

        d4.setNombrePersona(personasLista.get(3).getNombre());
        d4.setApellido(personasLista.get(3).getApellido());
        d4.setNombreDeporte(deporteLista.get(0).getNombre());

        List<DeportistaDTO> deportistaDTOS = new ArrayList<>();
        deportistaDTOS.add(d1);
        deportistaDTOS.add(d2);
        deportistaDTOS.add(d3);
        deportistaDTOS.add(d4);

        return deportistaDTOS;
    }
}
