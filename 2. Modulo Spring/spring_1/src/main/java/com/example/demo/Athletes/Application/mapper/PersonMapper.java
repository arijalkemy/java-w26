package com.example.demo.Athletes.Application.mapper;

import com.example.demo.Athletes.Application.out.response.PersonSportResponse;
import com.example.demo.Athletes.Domain.Person;
import com.example.demo.Athletes.Domain.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PersonMapper {

    List<PersonSportResponse> toPersonSportResponseList(List<Person> people);

    @Mapping(source = "sports", target = "sportName", qualifiedByName = "mapSportsToString")
    PersonSportResponse toPersonSportResponse(Person person);

    @Named("mapSportsToString")
    default String mapSportsToString(List<Sport> sports) {
        return sports.stream()
                .map(Sport::getName)
                .collect(Collectors.joining(", "));
    }


}

