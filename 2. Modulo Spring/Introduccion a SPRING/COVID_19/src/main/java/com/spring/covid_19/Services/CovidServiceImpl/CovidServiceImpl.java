package com.spring.covid_19.Services.CovidServiceImpl;

import com.spring.covid_19.Dtos.RiskPersonDto;
import com.spring.covid_19.Models.Persona;
import com.spring.covid_19.Models.Sintoma;
import com.spring.covid_19.Services.ICovidService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CovidServiceImpl implements ICovidService {
    List<Persona> personas = new ArrayList<>();
    List<Sintoma> sintomas = new ArrayList<>();
    public CovidServiceImpl(){
        personas.add(new Persona(1,"Lucas", "Martinez", 44));
        personas.add(new Persona(2,"Juan", "Dominguez", 84));
        personas.add(new Persona(3,"Pedro", "Gonzalez", 67));
        sintomas.add(new Sintoma("A1", "Perdida de olfato", "leve"));
        sintomas.add(new Sintoma("A12", "Perdida de Gusto", "leve"));
        sintomas.add(new Sintoma("A12", "Perdida de capacidad pulmonar", "Grave"));
    }

    @Override
    public List<Sintoma> findSymptoms() {
        return sintomas;
    }

    @Override
    public Optional<Sintoma> findSymptom(String nombre) {
        return sintomas
                .stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    @Override
    public List<RiskPersonDto> findRiskPersons() {
        List<RiskPersonDto> riskPersons = new ArrayList<>();

        for (Persona persona : personas) {
            int numSymptoms = new Random().nextInt(sintomas.size()) + 1; // al menos un síntoma


            List<Sintoma> randomSymptoms = new ArrayList<>();

            // Agregar síntomas aleatorios a la lista
            for (int i = 0; i < numSymptoms; i++) {
                int randomIndex = new Random().nextInt(sintomas.size());
                randomSymptoms.add(sintomas.get(randomIndex));
            }

            if (persona.getEdad() > 60){
                riskPersons.add(new RiskPersonDto(persona.getNombre(), persona.getApellido(), randomSymptoms));
            }
        }

        return riskPersons;
    }
}
