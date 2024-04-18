package com.Ejercicio.Covid.Service;

import com.Ejercicio.Covid.Entity.Symptom;
import com.Ejercicio.Covid.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SymptomServiceImplService implements ISymptomService {
    @Autowired
    Repository repository;
    @Override
    public List<Symptom> findSymtoms() {
        return Repository.symptomsList;
    }

    @Override
    public Optional<Integer> findLevelOfSeverityBy(String name) {
        return Repository.symptomsList.stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(Symptom::getLevelOfSeverity);
    }
}
