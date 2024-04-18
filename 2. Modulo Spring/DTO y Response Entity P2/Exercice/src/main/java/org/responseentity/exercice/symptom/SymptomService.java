package org.responseentity.exercice.symptom;

import java.util.List;

public interface SymptomService {
    List<SymptomEntity> listSymptoms();
    String getLevelOfSeverityByName(String name);
    void insertSymptom(SymptomEntity symptomEntity);

}
