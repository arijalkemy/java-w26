package com.example.EjercicioDeporte.services.impl;

import com.example.EjercicioDeporte.dto.DeporteDTO;
import com.example.EjercicioDeporte.dto.PersonaDTO;
import com.example.EjercicioDeporte.model.Deporte;
import com.example.EjercicioDeporte.model.Persona;
import com.example.EjercicioDeporte.services.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IDeporteServiceImpl implements IDeporteService {
    List<Deporte> deportes = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public IDeporteServiceImpl() {
        // Agregar síntomas harcodeados
        deportes.add(new Deporte( "Futbol", "Alto"));
        deportes.add(new Deporte( "Rugby", "Medio"));
        deportes.add(new Deporte( "Tennis", "Bajo"));

        // Agregar personas harcodeadas
        personas.add(new Persona("Juan", "Perez",30 , deportes.get(0)));
        personas.add(new Persona("María", "González",30 , deportes.get(2)));
        personas.add(new Persona("Carlos", "López",30 , null));
        personas.add(new Persona("Ana", "Martínez",30 , deportes.get(1)));
    }

    @Override
    public List<DeporteDTO> buscarTodosDeportes() {
        return deportes.stream().map(this::convertirADTO).toList();
    }

    @Override
    public String buscarPorNombre(String name) {
        for (Deporte deporte : deportes) {
            if (deporte.getNombre().equals(name)) {
                return "Nivel del deporte " + name + ": " + deporte.getNivel();
            }
        }
        return null;

    }

    @Override
    public List<PersonaDTO> buscarPersonasDeportistas() {
        return personas.stream().filter(persona -> persona.getDeporte() != null).map(this::convertirADTO).toList();
    }

    private DeporteDTO convertirADTO(Deporte deporte) {
        DeporteDTO dto = new DeporteDTO();
        dto.setNombre(deporte.getNombre());
        dto.setNivel(deporte.getNivel());
        return dto;
    }

    private PersonaDTO convertirADTO(Persona persona) {
        PersonaDTO dto = new PersonaDTO();
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        if(persona.getDeporte() != null) dto.setDeporte(persona.getDeporte().getNombre());
        return dto;
    }
}
