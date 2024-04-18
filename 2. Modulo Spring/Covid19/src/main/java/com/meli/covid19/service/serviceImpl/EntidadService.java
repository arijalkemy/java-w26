package com.meli.covid19.service.serviceImpl;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.dto.SintomaDTO;
import com.meli.covid19.service.IEntidad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.meli.covid19.repository.ListData.listPersonas;
import static com.meli.covid19.repository.ListData.listSintomas;

@Service
public class EntidadService implements IEntidad {
    @Override
    public List<SintomaDTO> findSymptom() {
        return listSintomas;
    }

    @Override
    public SintomaDTO findSymptom(String name) {
        Optional<SintomaDTO> optionalSintoma = listSintomas.stream().filter(sintoma -> sintoma.getNombre().equals(name)).map(sintoma -> new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivel_de_gravedad())).findFirst();
        if (optionalSintoma.isPresent()) {
            return optionalSintoma.map(sintoma -> new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivel_de_gravedad())).orElse(null);
        }
        return new SintomaDTO();
    }

    @Override
    public List<PersonaDTO> findRiskPerson(String name) {

        return listPersonas.stream()
                .filter(person -> person.getSintomas().stream()
                        .anyMatch(sintomaDTO -> sintomaDTO.getNombre().equals(name)))
                .collect(Collectors.toList());

    }
}
