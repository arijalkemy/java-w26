package com.w26.covid19.repository;

import com.w26.covid19.entity.Symptom;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Data
public class SymptomRepository {

    private List<Symptom> symptomRepositoryList;

    public SymptomRepository() {
        this.symptomRepositoryList = new ArrayList<>();
        this.load();
    }

    public void load()
    {
        Symptom symptom1 = new Symptom("Tos", Symptom.SEVERITY.MEDIUM);
        Symptom symptom2 = new Symptom("Fiebre", Symptom.SEVERITY.HIGHT);
        Symptom symptom3 = new Symptom("Dolor de cabeza", Symptom.SEVERITY.LOW);

        this.symptomRepositoryList.add(symptom1);
        this.symptomRepositoryList.add(symptom2);
        this.symptomRepositoryList.add(symptom3);

    }

    public Symptom getRandomSympt()
    {
        Random random = new Random();
        int symptomPosition = random.nextInt(0 , symptomRepositoryList.size());
        return symptomRepositoryList.get(symptomPosition);
    }
}
