package com.example.deportista.service.persona;

import com.example.deportista.dto.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonaService {
    ResponseEntity<List<PersonaDTO>> getPersonas();
}
