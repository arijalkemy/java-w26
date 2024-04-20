package com.sinc_ejerciciostarwars.service.implementacion;

import com.sinc_ejerciciostarwars.dto.PersonajeDTO;
import com.sinc_ejerciciostarwars.entidad.Personaje;
import com.sinc_ejerciciostarwars.repositorio.Repositorio;
import com.sinc_ejerciciostarwars.service.IPersonajeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonajeServiceImplementacion implements IPersonajeService {

    @Override
    public List<PersonajeDTO> buscarTodos() {
        List<PersonajeDTO> listaPersonajesDTO = new ArrayList<>();
        for (Personaje personaje : Repositorio.personajes) {
            listaPersonajesDTO.add(convertirADTO(personaje));
        }
        return listaPersonajesDTO;
    }

    @Override
    public List<PersonajeDTO> buscarPersonajePorNombre(String nombre) {
        List<PersonajeDTO> personajesDTOFiltrados = new ArrayList<>();
        for (Personaje personaje : Repositorio.personajes.stream()
                .filter(p -> p.getNombre().toUpperCase().contains(nombre.toUpperCase()))
                .toList()) {
            personajesDTOFiltrados.add(convertirADTO(personaje));
        }
        return personajesDTOFiltrados;
    }

    private PersonajeDTO convertirADTO(Personaje personaje) {
        return new PersonajeDTO(personaje.getNombre(),
                                personaje.getAltura(),
                                personaje.getPeso(),
                                personaje.getGenero(),
                                personaje.getHogar(),
                                personaje.getEspecie());
    }
}
