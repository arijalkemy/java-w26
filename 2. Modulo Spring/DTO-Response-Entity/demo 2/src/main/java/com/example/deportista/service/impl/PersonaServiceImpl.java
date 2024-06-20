package com.example.deportista.service.impl;

import com.example.deportista.entities.Persona;
import com.example.deportista.repository.IDeporteRepository;
import com.example.deportista.repository.IPersonaRepository;
import com.example.deportista.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> obtenerPersonas() {
        return iPersonaRepository.findAll();
    }
}
