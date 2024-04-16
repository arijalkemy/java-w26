package com.example.deportistas.controller;

import com.example.deportistas.DTO.DeportistaDTO;
import com.example.deportistas.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonasController{

    @Autowired
    IPersonaService servicePersona;

    @GetMapping("/findSportsPerson")
    public List<DeportistaDTO> verDeportistas(){
        return servicePersona.verDeportistas();
    }
}
