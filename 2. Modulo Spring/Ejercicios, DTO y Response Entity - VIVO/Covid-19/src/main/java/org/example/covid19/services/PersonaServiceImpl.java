package org.example.covid19.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.covid19.dto.PersonaDTO;
import org.example.covid19.dto.SintomaDto;
import org.example.covid19.entities.Persona;
import org.example.covid19.entities.Sintoma;
import org.example.covid19.repository.PersonaRepositorio;
import org.example.covid19.repository.SintomasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    SintomasRepositorio sintomasRepositorio;

    @Override
    public List<PersonaDTO> buscarPersonasDeRiesgo() {
        ObjectMapper mapper = new ObjectMapper();
        List<PersonaDTO>lista = new ArrayList<>();
        for (Persona persona : personaRepositorio.getPersonasMayores()){
            PersonaDTO personaDTO = mapper.convertValue(persona, PersonaDTO.class);
            List<String>listaSintomas = sintomasRepositorio.getListaDeSintomas().stream().map(Sintoma::getNombre).toList();
            personaDTO.setSintomas(listaSintomas);
            lista.add(personaDTO);
        }
        return lista;
    }
}
