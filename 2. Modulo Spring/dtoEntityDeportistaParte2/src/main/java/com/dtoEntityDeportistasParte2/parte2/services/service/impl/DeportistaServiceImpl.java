package com.dtoEntityDeportistasParte2.parte2.services.service.impl;

import com.dtoEntityDeportistasParte2.parte2.dto.DepostistaDTO;
import com.dtoEntityDeportistasParte2.parte2.entity.Deporte;
import com.dtoEntityDeportistasParte2.parte2.entity.Persona;
import com.dtoEntityDeportistasParte2.parte2.services.interfaces.IDeportistaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DeportistaServiceImpl implements IDeportistaService {

    private static final List<Persona> personaList = new ArrayList<>();
    private static final List<Deporte> deporteList = new ArrayList<>();

    static {
        personaList.add(new Persona("pedro", "arriaga", 27));
        personaList.add(new Persona("luis", "arriaga", 27));
        personaList.add(new Persona("luis", "arriaga", 27));

    }

    static {
        deporteList.add(new Deporte("futball", 1));
        deporteList.add(new Deporte("basquetall", 2));
        deporteList.add(new Deporte("basquetall", 2));
    }

    @Override
    public List<Deporte> findAll() {
        return deporteList;
    }

    @Override
    public String findSport(String sport) {
        return deporteList.stream().filter(deporte -> deporte.getNombre().equals(sport)).findFirst().get().toString();
    }

    @Override
    public List<DepostistaDTO> findSportsPersons() {
        List<DepostistaDTO> depostistasList = new ArrayList<>();
        DepostistaDTO depostistaDTO = new DepostistaDTO();
        for (int i = 0; i < deporteList.size(); i++) {
            depostistasList.add(new DepostistaDTO(personaList.get(i).getNombre(), personaList.get(i).getApellido(), deporteList.get(i).getNombre()));
        }


        return depostistasList;
    }
}
