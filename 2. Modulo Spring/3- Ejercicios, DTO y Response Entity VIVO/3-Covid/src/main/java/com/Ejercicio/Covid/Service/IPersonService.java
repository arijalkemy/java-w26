package com.Ejercicio.Covid.Service;

import com.Ejercicio.Covid.DTO.PersonDto;
import java.util.List;

public interface IPersonService {
    List<PersonDto> searchRiskPerson();
}
