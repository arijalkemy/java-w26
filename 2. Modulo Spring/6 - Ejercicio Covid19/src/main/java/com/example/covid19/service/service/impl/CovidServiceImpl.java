package com.example.covid19.service.service.impl;

import com.example.covid19.clases.Sintoma;
import com.example.covid19.db.DB;
import com.example.covid19.dto.PersonaDto;
import com.example.covid19.service.ICovidService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidServiceImpl implements ICovidService {
    DB db;

    public CovidServiceImpl() {
        this.db = new DB();
    }

    @Override
    public List<Sintoma> obtenerSintomas() {
        return db.getSintomas();
    }

    @Override
    public int nivelGravedad(String nombre) {

        List<Sintoma> sintomas = db.getSintomas();
        List<Sintoma> sintomasFiltro = sintomas.stream().filter( x -> x.getNombre().equals(nombre) ).toList();

        if( sintomasFiltro.size() != 0 ){
            return sintomasFiltro.stream().findFirst().get().getNivel_de_gravedad();
        }

        return -1;
    }

    @Override
    public List<PersonaDto> buscarPersonasDeRiesgo() {

        List<PersonaDto> personas = db.getPersonasDto();
        List<PersonaDto> personasRiesgo = personas.stream().filter( x ->
                x.getEdadPersona() > 60 && x.getSintomas().size() > 0
                ).toList();

        if( personasRiesgo.size() != 0 ){
            return personasRiesgo;
        }

        return null;
    }
}
