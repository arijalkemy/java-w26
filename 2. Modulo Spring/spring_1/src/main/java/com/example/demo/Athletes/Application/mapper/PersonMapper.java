package com.example.demo.Athletes.Application.mapper;

import com.example.demo.Athletes.Application.out.response.PersonSportResponse;
import com.example.demo.Athletes.Domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = SportMapper.class)
public interface PersonMapper {

    List<PersonSportResponse> toPersonSportResponseList(List<Person> people);

    @Mapping(source = "sports", target = "sportName", qualifiedByName = "mapSportsToString")
    PersonSportResponse toPersonSportResponse(Person person);


}

