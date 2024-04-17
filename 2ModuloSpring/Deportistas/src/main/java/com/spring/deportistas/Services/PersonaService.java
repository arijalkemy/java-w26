package com.spring.deportistas.Services;

import com.spring.deportistas.Models.Deporte;
import com.spring.deportistas.Models.Persona;
import com.spring.deportistas.Models.dtos.PersonaDto;
import com.spring.deportistas.Repository.MockDB;
import com.spring.deportistas.Services.Interfaces.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonaService implements IPersonaService {

    @Override
    public List<PersonaDto> getAllWithDeportes() {
        List<PersonaDto> personaDtoList = new ArrayList<>();
         MockDB.personsList.stream().forEach(p -> {
             PersonaDto personaDto = new PersonaDto();
             List<String> nombreDepList = new ArrayList<>();
             p.getDeporteList().stream().forEach(dl -> {
                 nombreDepList.add(dl.getNombre());
             });
             personaDto.setNombreDeporteList(nombreDepList);
             personaDto.setFullName(p.getNombre() + " " + p.getApellido());
             personaDtoList.add(personaDto);
         });

        return personaDtoList;
    }
}
