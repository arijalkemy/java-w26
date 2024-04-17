package com.example.dto_y_response_entityp2_covid.controller;

import com.example.dto_y_response_entityp2_covid.dto.PersonaDTO;
import com.example.dto_y_response_entityp2_covid.entity.Sintoma;
import com.example.dto_y_response_entityp2_covid.service.serviceSintomaImpl.ServiceSintomaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class SintomaController {

    @Autowired
    ServiceSintomaImpl serviceSintoma;

    @GetMapping("/findSymptom")
    public List<Sintoma> findSymptom() {

        return serviceSintoma.findSymptom();
    }

    @GetMapping("/findSymptom/{symptom}")
    public ResponseEntity<Integer> findSpecificSymptom(@PathVariable String symptom) {
        return serviceSintoma.findSpecificSymptom(symptom);
    }

    @GetMapping("/findPersonInRisk")
    public List<PersonaDTO> findPersonInRisk() {
        return serviceSintoma.findRiskPerson();
    }
}
