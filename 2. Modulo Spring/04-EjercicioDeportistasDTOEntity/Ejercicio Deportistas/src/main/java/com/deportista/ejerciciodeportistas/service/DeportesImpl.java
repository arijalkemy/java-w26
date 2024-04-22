package com.deportista.ejerciciodeportistas.service;

import com.deportista.ejerciciodeportistas.models.Deporte;
import com.deportista.ejerciciodeportistas.models.Persona;
import com.deportista.ejerciciodeportistas.models.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeportesImpl implements IDeportes{

    private static List<Deporte> deportesRepo = Arrays.asList(
            new Deporte("Hockey", "Amateur"),
            new Deporte("Futbol", "Semi-Pro"),
            new Deporte("Waterpolo", "Profesional"),
            new Deporte("Gimnasia", "Recreativo"));

    private static List<Persona> personasRepo = Arrays.asList(
            new Persona("Andres", "Garcia", 26, deportesRepo.get(0)),
            new Persona("Joaquin", "Sanchez", 29, deportesRepo.get(1)),
            new Persona("Dylan", "Quito", 65, deportesRepo.get(2)),
            new Persona("Lucia", "Fernandez", 76, deportesRepo.get(3)),
            new Persona("Malena", "Perez", 23, deportesRepo.get(2)),
            new Persona("Stella", "Salvucci", 34, deportesRepo.get(1)));


    @Override
    public String verDeportes() {
        StringBuilder resultado = new StringBuilder();
        for (Deporte deporte : deportesRepo){
            resultado.append(deporte.toString());
        }
        return resultado.toString();
    }

    @Override
    public Deporte chequearDeportes(String nombreDeporte) {
        Deporte deporteResponse = new Deporte();
        return deportesRepo.stream().filter(x -> x.getNombre().equals(nombreDeporte)).findFirst().orElse(deporteResponse);
    }

    @Override
    public List<PersonaDTO> verDeportistas() {
        List<PersonaDTO> personaDTOResponse = new ArrayList<>();
        this.personasRepo
                .forEach(x -> personaDTOResponse
                .add(new PersonaDTO(x.getNombre(), x.getApellido(), x.getDeporte().getNombre())));
        return personaDTOResponse;
    }

}
