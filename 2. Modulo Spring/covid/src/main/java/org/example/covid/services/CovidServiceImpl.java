package org.example.covid.services;

import org.example.covid.dto.PersonaEnRiesgoDTO;
import org.example.covid.entity.Persona;
import org.example.covid.entity.Sintoma;
import org.example.covid.services.interfaces.ICovidService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CovidServiceImpl implements ICovidService {
    public static final List<Sintoma> sitomasList = new ArrayList<>();
    public static final List<Persona> personasList = new ArrayList<>();

    static {
        sitomasList.add(new Sintoma(1, "covid 001", 1));
        sitomasList.add(new Sintoma(2, "covid 002", 2));
        sitomasList.add(new Sintoma(3, "covid 003", 3));
        sitomasList.add(new Sintoma(4, "covid 004", 4));
        sitomasList.add(new Sintoma(5, "covid 004", 5));
    }

    static {
        personasList.add(new Persona(1, "pedro", "arriaga", 27));
        personasList.add(new Persona(2, "luis", "lopez", 60));
        personasList.add(new Persona(3, "arturo", "arriaga", 61));
        personasList.add(new Persona(4, "jorge", "hernandez", 59));
        personasList.add(new Persona(5, "gerardo", "soto", 65));
    }

    @Override
    public List<Sintoma> findSymptom() {
        return sitomasList;
    }

    @Override
    public List<Sintoma> findSymptomByName(String symptomName) {
        List<Sintoma> sintomaFilter = sitomasList.stream().filter(sintoma -> sintoma.getNombre().contains(symptomName)).toList();
        return sintomaFilter;
    }

    @Override
    public List<PersonaEnRiesgoDTO> findRiskPerson() {
        List<Persona> personaListRiesgo = personasList.stream().filter(persona -> persona.getEdad() > 60).toList();
        List<PersonaEnRiesgoDTO> personaEnRiesgoDTO = new ArrayList<>();

        for (int i = 0; i < personaListRiesgo.size(); i++) {
            personaEnRiesgoDTO.add(new PersonaEnRiesgoDTO(personaListRiesgo.get(i).getNombre(),
                    personaListRiesgo.get(i).getApellido(), sitomasList.get(i).getNombre()));
        }
        return personaEnRiesgoDTO;
    }
}
