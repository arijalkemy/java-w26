package org.example.ejerciciodeportistas.services;

import org.example.ejerciciodeportistas.dto.PersonDto;
import org.example.ejerciciodeportistas.models.Person;

import java.util.List;

public interface IpersonServices {
    List<PersonDto> findPersons();
}
