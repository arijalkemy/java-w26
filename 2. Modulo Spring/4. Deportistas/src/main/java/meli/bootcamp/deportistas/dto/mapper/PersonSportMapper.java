package meli.bootcamp.deportistas.dto.mapper;

import meli.bootcamp.deportistas.dto.PersonSportDto;
import meli.bootcamp.deportistas.entities.Person;

public class PersonSportMapper {
    public static PersonSportDto toDto(Person person) {
        return PersonSportDto.builder()
                .name(person.getName())
                .surname(person.getSurname())
                .sport(person.getSport().getName())
                .build();
    }
}
