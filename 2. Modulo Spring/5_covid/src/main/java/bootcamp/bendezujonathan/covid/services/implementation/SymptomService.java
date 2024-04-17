package bootcamp.bendezujonathan.covid.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.covid.model.Symptom;
import bootcamp.bendezujonathan.covid.repository.interfaces.ISymptomRepository;
import bootcamp.bendezujonathan.covid.services.interfaces.ISymptomService;

@Service
public class SymptomService implements ISymptomService {

    @Override
    public Optional<Symptom> findByName(String name) {
        return ISymptomRepository.findAll()
                            .stream()
                            .filter(symptom -> symptom.getName()
                            .equalsIgnoreCase(name))
                            .findFirst();
    }

    @Override
    public List<Symptom> findAll() {
       return ISymptomRepository.findAll();
    }
    
}
