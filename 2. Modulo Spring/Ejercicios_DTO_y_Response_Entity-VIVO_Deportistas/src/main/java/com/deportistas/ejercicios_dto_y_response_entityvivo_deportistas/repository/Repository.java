package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.repository;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.dto.PersonDTO;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models.Person;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models.Sport;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.IPersonRepository;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.ISportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository implements ISportRepository, IPersonRepository {

    private static final List<Sport> sportList = Arrays.asList(
            new Sport("Futbool", 10),
            new Sport("Basquetball", 12)
    );

    private static final List<Person> personList = Arrays.asList(
            new Person("Luis", "Meza", 24),
            new Person("Maria", "Arguello", 29)
    );

    public List<Sport> getSportList() {
        return sportList;
    }

    @Override
    public ResponseEntity<Integer> findSport(String name) {
        for (Sport sport : sportList) {
            if (sport.getName().equals(name)) {
                return ResponseEntity.status(200).body(sport.getLevel());
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
    }

    @Override
    public PersonDTO getPersonSport() {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setName(personList.get(0).getName());
        personDTO.setLastName(personList.get(0).getLastName());
        personDTO.setSport(sportList.get(0));

        return personDTO;

    }
}
