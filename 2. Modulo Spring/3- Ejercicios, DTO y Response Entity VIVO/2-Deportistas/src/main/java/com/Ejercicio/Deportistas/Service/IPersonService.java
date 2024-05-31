package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.DTO.PersonDTO;
import java.util.List;

public interface IPersonService {
    List<PersonDTO> findAllPerson();
}
