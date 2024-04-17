package com.bootcampjava.covid19.serviceImp;

import com.bootcampjava.covid19.dataBase.PersonsData;
import com.bootcampjava.covid19.model.DTOs.PersonaRiesgoDTO;
import com.bootcampjava.covid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonaServiceImp implements IPersonaService {

    PersonsData personasdata = new PersonsData();
    @Override
    public List<PersonaRiesgoDTO> obtenerPersonasConRiesgo() {

        return null;
    }
}
