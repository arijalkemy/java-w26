package ejerciciocovid.ejerciciocovid.Service;

import ejerciciocovid.ejerciciocovid.Entity.Symptom;

import java.util.List;
import java.util.Optional;

public interface IsymptomService {
    public List<Symptom> getAllSymptoms();
    public Optional<Symptom> getSymptom(String name);
}
