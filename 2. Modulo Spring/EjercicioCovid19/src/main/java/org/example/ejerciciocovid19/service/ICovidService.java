package org.example.ejerciciocovid19.service;

import org.example.ejerciciocovid19.dto.PatientDTO;
import org.example.ejerciciocovid19.dto.SymptomDTO;

import java.util.List;

public interface ICovidService {
    public List<SymptomDTO> searchAllSymptoms();
    public int searchSymptom(String name);
    public List<PatientDTO> searchPatientsBySymptom();
}
