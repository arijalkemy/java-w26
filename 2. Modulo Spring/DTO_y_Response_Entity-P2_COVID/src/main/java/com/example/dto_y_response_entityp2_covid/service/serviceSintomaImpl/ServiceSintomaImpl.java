package com.example.dto_y_response_entityp2_covid.service.serviceSintomaImpl;

import com.example.dto_y_response_entityp2_covid.dto.PersonaDTO;
import com.example.dto_y_response_entityp2_covid.entity.Persona;
import com.example.dto_y_response_entityp2_covid.entity.Sintoma;
import com.example.dto_y_response_entityp2_covid.service.IServiceSintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceSintomaImpl implements IServiceSintoma {

    private static List<Sintoma> sintomaList = Arrays.asList(
            new Sintoma(101, "Gripe", 5),
            new Sintoma(102, "Diarrea", 4)
    );

    private static List<Persona> personaList = Arrays.asList(
            new Persona(1001, "Luis", "Meza", 24, 101),
            new Persona(1002, "Maria", "Arguello", 61, 102)
    );

    @Override
    public List<Sintoma> findSymptom() {
        return sintomaList;
    }

    @Override
    public ResponseEntity<Integer> findSpecificSymptom(String symptom) {
        List<Sintoma> auxList = sintomaList.stream().filter(s -> s.getNombre().equals(symptom)).toList();

        if (auxList.isEmpty()) {
            return ResponseEntity.badRequest().body(-1);
        }

        return ResponseEntity.status(200).body(auxList.get(0).getNivel_de_gravedad());
    }

    @Override
    public List<PersonaDTO> findRiskPerson() {
        List<PersonaDTO> personaDTOList = new ArrayList<>();
        for (Persona p : personaList) {
            if (p.getEdad()>60) {
                PersonaDTO personaDTO = new PersonaDTO();
                List<Sintoma> auxList = sintomaList.stream().filter(s -> s.getCodigo().equals(p.getCodigoSintoma())).toList();
                if (auxList.isEmpty()) {
                    return null;
                }

                personaDTO.setSintoma(auxList.get(0));
                personaDTO.setNombre(p.getNombre());
                personaDTO.setApellido(p.getApellido());
                personaDTO.setEdad(p.getEdad());
                personaDTOList.add(personaDTO);
            }

        }

        return personaDTOList;
    }


}
