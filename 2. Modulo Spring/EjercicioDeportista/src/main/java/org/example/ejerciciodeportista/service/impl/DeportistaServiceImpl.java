package org.example.ejerciciodeportista.service.impl;

import org.example.ejerciciodeportista.dto.DeporteDTO;
import org.example.ejerciciodeportista.dto.DeportistaDTO;
import org.example.ejerciciodeportista.entity.Deporte;
import org.example.ejerciciodeportista.entity.Persona;
import org.example.ejerciciodeportista.service.IDeportistaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeportistaServiceImpl implements IDeportistaService {
    static List<Deporte> deportes = new ArrayList<>();
    static List<Persona> personas = new ArrayList<>();


    static {
        deportes.add(new Deporte("Futbol", 5));
        deportes.add(new Deporte("Baloncesto", 3));
        deportes.add(new Deporte("Tenis", 4));
    }

    static {
        personas.add(new Persona("Juan", "Perez", 25));
        personas.add(new Persona("Maria", "Lopez", 30));
        personas.add(new Persona("Pedro", "Garcia", 19));
    }

    @Override
    public List<DeporteDTO> findAllDeportes() {
        List<DeporteDTO> deportesDTO = new ArrayList<>();
        for (Deporte deporte : deportes) {
            deportesDTO.add(new DeporteDTO(deporte.getNombreDeporte(), deporte.getNivel()));
        }
        return deportesDTO;
    }
    @Override
    public List<DeporteDTO> findDeportesByName(String name) {
        List<DeporteDTO> resultado = new ArrayList<>();
        resultado=deportes.stream()
                .filter(deporte -> deporte.getNombreDeporte().equals(name))
                .map(deporte -> new DeporteDTO(deporte.getNombreDeporte(), deporte.getNivel()))
                .toList();

        return resultado;
    }
    public List<DeportistaDTO> fillDeportistas(List<DeportistaDTO> deportistas) {
        for (Persona persona : personas) {
            deportistas.add(new DeportistaDTO(persona.getNombre(), persona.getApellidos(), deportes.get((int) (Math.random() * 2)).getNombreDeporte()));
        }
        return deportistas;
    }
    @Override
    public List<DeportistaDTO> findDeportistas(){
        List<DeportistaDTO> deportistas = new ArrayList<>();
        deportistas = fillDeportistas(deportistas);
        return deportistas;

    }

}
