package bootcamp.bendezujonathan.covid.services.interfaces;

import java.util.List;
import java.util.Optional;

import bootcamp.bendezujonathan.covid.model.Symptom;

public interface ISymptomService {
    
    Optional<Symptom> findByName(String name);
    List<Symptom> findAll();
}
