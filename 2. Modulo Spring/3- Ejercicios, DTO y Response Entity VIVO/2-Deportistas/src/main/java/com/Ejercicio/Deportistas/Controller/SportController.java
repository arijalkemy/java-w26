package com.Ejercicio.Deportistas.Controller;

import com.Ejercicio.Deportistas.Entity.DTO.PersonDTO;
import com.Ejercicio.Deportistas.Entity.Sport;
import com.Ejercicio.Deportistas.Service.ISport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sportController")
public class SportController {
    @Autowired
    ISport iSportImpl;

    @GetMapping(path = "/getSports")
    public List<Sport> getSports() {
        return iSportImpl.getSports();
    }

    @GetMapping(path = "/getSportByName")
    public Optional<?> getSportByName(@RequestParam String name){
        return iSportImpl.getLevelSportBy(name);
    }

    @GetMapping(path = "/getAthletes")
    public List<PersonDTO> getAthletes(){
        return iSportImpl.getPersons();
    }
}
