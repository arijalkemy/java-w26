package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.sportimpl;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.dto.PersonDTO;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.IPersonRepository;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonImpl  implements IPersonService {

    @Autowired
    IPersonRepository personRepository;

    @Override
    public PersonDTO getPersonSport() {
        return personRepository.getPersonSport();
    }
}
