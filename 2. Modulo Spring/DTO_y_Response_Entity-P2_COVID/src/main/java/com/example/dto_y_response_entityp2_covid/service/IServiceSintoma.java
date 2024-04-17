package com.example.dto_y_response_entityp2_covid.service;
import com.example.dto_y_response_entityp2_covid.dto.PersonaDTO;
import com.example.dto_y_response_entityp2_covid.entity.Sintoma;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServiceSintoma {
    public List<Sintoma> findSymptom();
    public ResponseEntity<Integer> findSpecificSymptom(String symptom);

    public List<PersonaDTO> findRiskPerson();
}
