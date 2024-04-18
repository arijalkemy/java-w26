package com.Ejercicio.Covid.Service;

import com.Ejercicio.Covid.Entity.Symptom;
import java.util.List;
import java.util.Optional;

public interface ISymptomService {
    List<Symptom> findSymtoms();

    Optional<Integer> findLevelOfSeverityBy(String name);
}
