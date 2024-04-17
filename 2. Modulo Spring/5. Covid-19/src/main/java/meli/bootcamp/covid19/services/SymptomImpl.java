package meli.bootcamp.covid19.services;

import meli.bootcamp.covid19.entities.Symptom;
import meli.bootcamp.covid19.repositories.SymptomRepository;
import meli.bootcamp.covid19.services.interfaces.ICrud;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomImpl implements ICrud<Symptom> {

    private final List<Symptom> symptoms;

    public SymptomImpl() {
        this.symptoms = SymptomRepository.symptoms;
    }

    @Override
    public List<Symptom> getAll() {
        return this.symptoms;
    }

    @Override
    public Symptom getOne(String name) {
        return this.symptoms.stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
