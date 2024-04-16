package org.example.dtosport.service;

import org.example.dtosport.entity.dto.SportPersonDto;

import java.util.List;

public interface ISportPerson {
    List<SportPersonDto> findSportPerson();
}
