package bootcamp.jonathan.sports.services.implementation;

import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import bootcamp.jonathan.sports.model.Sport;
import bootcamp.jonathan.sports.repositories.interfaces.ISportRepository;
import bootcamp.jonathan.sports.services.interfaces.ISportService;

@Service
public class SportService implements ISportService {

    private static final Random RANDOMIZER = new Random();

    @Override
    public List<Sport> findSports() {
        return ISportRepository.findAll();
    }

    @Override
    public Sport findByName(String name) {
        return ISportRepository.findAll()
                .stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Sport random() {
        return ISportRepository.findAll()
                .get(RANDOMIZER.nextInt(2));
    }

}
