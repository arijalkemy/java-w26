package org.ejercicio.deportistas.service.implementation;

import org.ejercicio.deportistas.model.Sport;
import org.ejercicio.deportistas.model.Sporty;
import org.ejercicio.deportistas.model.dto.SportyDTO;
import org.ejercicio.deportistas.service.IRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("sporty")
public class SportyRepository implements IRepository<SportyDTO> {
    public static List<Sporty> sporties = Arrays.asList(
            new Sporty("Lionel","Messi", 36, SportRepository.sports.get(0)),
            new Sporty("Cristiano","Ronaldo", 39, SportRepository.sports.get(0)),
            new Sporty("Rigoberto","Uran", 37, SportRepository.sports.get(1)),
            new Sporty("Miguel","Induráin", 59, SportRepository.sports.get(1))
    );

    @Override
    public SportyDTO findByName(String name) {
        return sporties.stream().filter(s -> s.getName().equals(name)).map(s ->
                new SportyDTO(s.getName(),s.getLastName(),s.getSport().getName())
                ).findFirst().orElse(null);
    }

    @Override
    public List<SportyDTO> findAll() {
        return sporties.stream().map(s ->
                new SportyDTO(s.getName(),s.getLastName(),s.getSport().getName())
        ).collect(Collectors.toList());
    }
}
