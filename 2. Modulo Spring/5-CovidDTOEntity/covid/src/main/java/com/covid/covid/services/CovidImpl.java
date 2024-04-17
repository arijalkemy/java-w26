package com.covid.covid.services;

import com.covid.covid.models.Persona;
import com.covid.covid.models.Sintoma;
import com.covid.covid.models.dto.PersonasRiesgoDTO;
import com.covid.covid.models.dto.SintomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CovidImpl implements ICovid{

    private List<Sintoma> listaSintomas = Arrays.asList(
            new Sintoma(1, "Tos", "Bajo"),
            new Sintoma(2, "Fiebre", "Alto"),
            new Sintoma(3, "Perdida Olfato", "Bajo"),
            new Sintoma(4, "Fatiga", "Medio"),
            new Sintoma(5, "Congestion", "Bajo"));

    private List<Persona> listaPersonas = Arrays.asList(
            new Persona(1, "Andres", "Garcia", 66, listaSintomas),
            new Persona(2, "Pity", "Martinez", 61, listaSintomas.subList(1,3)),
            new Persona(3, "Estaban", "Quito", 66),
            new Persona(4, "Charly", "Garcia", 50, listaSintomas.subList(1,3)));


    @Override
    public List<Sintoma> getSintomas() {
        return listaSintomas;
    }

    @Override
    public SintomaDTO getSintomaPorNombre(String nombre){

        //busca el sintoma deseado en la lista de sintomas
        Sintoma sintoma = listaSintomas.stream()
                .filter(x -> x.getNombre()
                .equals(nombre)).findFirst()
                .orElse(null);
        SintomaDTO sintomaResponse = new SintomaDTO(sintoma.getNombre(), sintoma.getNivelDeGravedad());
        return sintomaResponse;
    }

    @Override
    public List<PersonasRiesgoDTO> getPersonasRiesgo() {
    List<PersonasRiesgoDTO> listaResponse = new ArrayList<>();
    //filtra a las personas mayores de 60 y que posean una lista de sintomas
    List<Persona> listaPersonasRiesgo = listaPersonas.stream()
            .filter(x -> (x.getEdad() > 60) && (x.getSintomas() != null))
            .toList();
    //se llena la lista de personas de riesgo dto
    listaPersonasRiesgo.forEach(x -> listaResponse
            .add(new PersonasRiesgoDTO(x.getNombre(), x.getApellido())));

        return listaResponse;
    }
}
