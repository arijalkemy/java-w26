package org.example.covid.service.impl;

import org.example.covid.model.PersonaSintomaDTO;
import org.example.covid.model.SintomaDTO;
import org.example.covid.repository.RepositorioGeneral;
import org.example.covid.service.ICovidService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidServiceImpl implements ICovidService {

    RepositorioGeneral repo = new RepositorioGeneral();

    @Override
    public List<SintomaDTO> verSintomas() {
        return repo.traerListaSintomaDTO();
    }

    @Override
    public SintomaDTO verSintoma(String nombre) {
        return repo.traerListaSintomaDTO().stream().filter(s -> s.getNombre()
                .equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    @Override
    public List<PersonaSintomaDTO> verPersonasDeRiesgo() {
        List<PersonaSintomaDTO> personasSintomas = repo.traerListaPersonaSintomaDTO();
        return personasSintomas.stream()
                .filter(p -> p.getEdad() >= 60 && !p.getNombreSintoma().isEmpty())
                .collect(Collectors.toList());
    }
}

