package com.example.deportistas.Controller;

import com.example.deportistas.Entity.Deporte;
import com.example.deportistas.Service.DeporteServiceImpl;
import com.example.deportistas.Service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class DeporteController {

    @Autowired
    DeporteServiceImpl deporteService;

    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping("/findSports")
    public List<Deporte> todosLosDeportes(){
        return deporteService.todosLosDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Integer> encuentraDeporte(@PathVariable String name){
        return new ResponseEntity<>(deporteService.busquedaPorNombre(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public String personasConDeporte(){
        return personaService.personasDeportistas();
    }


}
