package meli.bootcamp.covid19.dto.mapper;

import meli.bootcamp.covid19.dto.PersonSymptomDto;
import meli.bootcamp.covid19.entities.Person;

public class Mapper {
    public static PersonSymptomDto toPersonSymptomDto(Person person) {
        return PersonSymptomDto.builder()
                .fullName(person.getName() + " " + person.getSurname())
                .age(person.getAge())
                .symptoms(person.getSymptoms())
                .build();
    }
}
