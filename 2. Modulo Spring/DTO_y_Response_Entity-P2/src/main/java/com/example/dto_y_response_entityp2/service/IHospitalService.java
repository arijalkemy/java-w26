package com.example.dto_y_response_entityp2.service;

import com.example.dto_y_response_entityp2.dto.PersonDTO;
import com.example.dto_y_response_entityp2.dto.SymptomsDto;

import java.util.List;

public interface IHospitalService {
    List<SymptomsDto> getAllSymptoms();

    SymptomsDto getSymptom(String name);

    List<PersonDTO> getRiskPersons();
}
