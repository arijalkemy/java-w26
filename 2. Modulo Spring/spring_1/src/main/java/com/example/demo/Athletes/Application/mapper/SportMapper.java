package com.example.demo.Athletes.Application.mapper;

import com.example.demo.Athletes.Domain.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface SportMapper {

    @Named("mapSportsToString")
    default String mapSportsToString(List<Sport> sports) {
        return sports.stream()
                .map(Sport::getName)
                .collect(Collectors.joining(", "));
    }

}
