package com.spring.deportistas.Controllers;

import com.spring.deportistas.Models.Deporte;
import com.spring.deportistas.Services.DeporteService;
import com.spring.deportistas.Services.Interfaces.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/deportes")
public class DeporteController {

    @Autowired
    IDeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllSports(){
        return new ResponseEntity<>(deporteService.getAllSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {

        String nivel = deporteService.findLevelBySportName(name);

        if(nivel == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(deporteService.findLevelBySportName(name), HttpStatus.OK);
    }
}
