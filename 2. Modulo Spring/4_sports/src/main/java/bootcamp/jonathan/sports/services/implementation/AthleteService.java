package bootcamp.jonathan.sports.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.jonathan.sports.model.Athlete;
import bootcamp.jonathan.sports.repositories.interfaces.IAthleteRepository;
import bootcamp.jonathan.sports.services.interfaces.IAthleteService;

@Service
public class AthleteService implements IAthleteService {

    @Override
    public List<Athlete> findAthlete() {
        return IAthleteRepository.findAll();
    }

}
