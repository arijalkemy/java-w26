package com.example.deportista.service.persona.imp;


import com.example.deportista.dto.PersonaDTO;
import com.example.deportista.service.persona.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements IPersonaService {
    @Override
    public ResponseEntity<List<PersonaDTO>> getPersonas() {
        List<PersonaDTO> personas = PersonaDTO.getPersonas();
        if(personas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
}
