package com.spring.deportistas.services;

import com.spring.deportistas.models.dto.PersonSportDTO;

import java.util.List;

public interface IPersonsService {

    List<PersonSportDTO> getAllPersonsSports();

}
