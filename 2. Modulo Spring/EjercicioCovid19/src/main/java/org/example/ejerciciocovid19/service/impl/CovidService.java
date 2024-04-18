package org.example.ejerciciocovid19.service.impl;

import org.example.ejerciciocovid19.dto.PatientDTO;
import org.example.ejerciciocovid19.dto.SymptomDTO;
import org.example.ejerciciocovid19.entity.Symptom;
import org.example.ejerciciocovid19.service.ICovidService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidService implements ICovidService {
    static List<Symptom> symptoms= new ArrayList<>();
    static List<PatientDTO> patients = new ArrayList<>();
    static {
        symptoms.add(new Symptom(1,"Fiebre",4));
        symptoms.add(new Symptom(2,"Cuerpo cortado",3));
        symptoms.add(new Symptom(3,"Congestion",1));
        symptoms.add(new Symptom(4,"Tos",2));
    }

    static{
        patients.add(new PatientDTO("Juan", "Gonzalez",65,"Fiebre"));
        patients.add(new PatientDTO("Maria", "Perez", 45,"Cuerpo cortado"));
        patients.add(new PatientDTO("Pedro", "Juarez", 70,"Congestion"));
        patients.add(new PatientDTO("Ana", "Diaz", 68,"Dolor de pie"));
    }
    @Override
    public List<SymptomDTO> searchAllSymptoms() {
        List<SymptomDTO> result = new ArrayList<>();
        for(Symptom s: symptoms){
            result.add(new SymptomDTO(s.getCode(), s.getSymptomName(), s.getLevelOfSeverity()));
        }
        return result;
    }
    @Override
    public int searchSymptom(String name) {
        for(Symptom s: symptoms){
            if(s.getSymptomName().equalsIgnoreCase(name)){
                return s.getLevelOfSeverity();
            }
        }
        return 0;
    }
    @Override
    public List<PatientDTO> searchPatientsBySymptom(){
        List<PatientDTO> result = new ArrayList<>();
        List<String> symptomNames = searchAllSymptoms().stream().map(SymptomDTO::getSymptomName).toList();
        result=patients.stream().filter(p->p.getAge()>=60&& symptomNames.contains(p.getSymptomName())).toList();
        return result;
    }


}
