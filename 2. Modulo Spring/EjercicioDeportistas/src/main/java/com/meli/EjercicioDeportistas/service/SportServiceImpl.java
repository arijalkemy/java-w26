package com.meli.EjercicioDeportistas.service;

import com.meli.EjercicioDeportistas.models.Person;
import com.meli.EjercicioDeportistas.models.Sport;
import com.meli.EjercicioDeportistas.dto.SportPersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImpl implements ISportService {

    private final Sport sportUno = new Sport("SportUno", 1);
    private final Sport sportDos = new Sport("SportDos", 2);
    private final Sport sportTres = new Sport("SportTres", 3);

    private final List<Sport> sportList = List.of(sportUno, sportDos, sportTres);

    private final List<Person> personList = List.of(new Person("PersonUno", "Uno", 20, sportUno),
            new Person("PersonDos", "Dos", 25, sportDos),
            new Person("PersonTres", "Tres", 18, sportTres));

    @Override
    public List<Sport> getAll() {
        return sportList;
    }

    @Override
    public Optional<Sport> getByName(String sportName) {
        return sportList.stream()
                .filter(t -> t.getName().equals(sportName))
                .findFirst();
    }

    @Override
    public List<SportPersonDTO> getSportsPersons() {
        return buildSportPerson();
    }

    private List<SportPersonDTO> buildSportPerson(){
        return personList.stream()
                .map(i -> new SportPersonDTO(i.getName(), i.getLastName(), i.getSport().getName()))
                .toList();
    }
}
