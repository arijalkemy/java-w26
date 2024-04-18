package org.responseentity.exercice.symptom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SymptomRepository {
    private List<SymptomEntity> symptoms;

    public SymptomRepository(){
        this.symptoms = new ArrayList<>();
    }

    public List<SymptomEntity> getAllSymptoms(){
        return this.symptoms;
    }

    public String getLevelOfSeverityByName(String name){
        Optional<SymptomEntity> symptomToSearch = this.symptoms
                .stream()
                .filter(symp -> symp.getName().equals(name))
                .findFirst();

        if(symptomToSearch.get() != null){
            return symptomToSearch.get().getLevelOfSeverity();
        }else{
            return "level of severity not found";
        }

    }


    public void insertSymptom(SymptomEntity symptom){
        this.symptoms.add(symptom);
    }
}
