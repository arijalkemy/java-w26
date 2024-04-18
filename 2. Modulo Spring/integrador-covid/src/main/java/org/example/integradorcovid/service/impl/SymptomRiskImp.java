package org.example.integradorcovid.service.impl;

import org.example.integradorcovid.dto.SymptomRiskDTO;
import org.example.integradorcovid.model.Person;
import org.example.integradorcovid.model.Symptom;
import org.example.integradorcovid.repository.SymptomRiskRepository;
import org.example.integradorcovid.service.ISymptom;
import org.example.integradorcovid.service.ISymptomRisk;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomRiskImp implements ISymptom<Symptom>, ISymptomRisk<SymptomRiskDTO> {

    // Injecting dependencies
    private final SymptomRiskRepository symptomRiskRepository;

    public SymptomRiskImp(SymptomRiskRepository symptomRiskRepository){
        this.symptomRiskRepository = symptomRiskRepository;
    }


    @Override
    public List<Symptom> findAll() {
        return symptomRiskRepository.getSymptomsList();
    }

    @Override
    public Symptom find(String name) {
        Symptom symptomSearch = new Symptom();
        for (Symptom symptom : symptomRiskRepository.getSymptomsList()){
            if (symptom.getName().equals(name)){
                symptomSearch = symptom;
            }
        }

        return symptomSearch;
    }

    @Override
    public List<SymptomRiskDTO> findRelated() {
        List<SymptomRiskDTO> riskPersons = new ArrayList<>();

        for (Person person: symptomRiskRepository.getPersonList()){
            if (person.getSymptoms() != null && person.getAge() >= 60){
                SymptomRiskDTO riskDTO = new SymptomRiskDTO(

                        person.getName() + " ",
                        person.getLastName()
                );
                riskPersons.add(riskDTO);
            }
        }

        return riskPersons;



    }
}
