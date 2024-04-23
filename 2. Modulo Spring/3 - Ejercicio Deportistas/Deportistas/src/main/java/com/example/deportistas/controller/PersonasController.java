package com.example.deportistas.controller;

import com.example.deportistas.DTO.DeportistaDTO;
import com.example.deportistas.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonasController{

    @Autowired
    IPersona servicePersona;

    @GetMapping("/findSportsPerson")
    public List<DeportistaDTO> verDeportistas(){
        return servicePersona.verDeportistas();
    }
}
