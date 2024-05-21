package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    IJoyaService joyaServ;

    @PostMapping ("/new")
    public ResponseEntity<String> saveJoya (@RequestBody Joya joya) {

        String id = joyaServ.saveJoya(joya);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Joya>> getJoyas () {
        List<Joya> joyas = joyaServ.getJoyas();
        return new ResponseEntity<>(joyas, HttpStatus.OK);
    }

    //como es un borrado lógico, se trata más bien de un update y no de un delete
    //por eso usamos put
    @PutMapping ("/delete/{id}")
    public ResponseEntity<String> deleteJoya (@PathVariable Long id) {

        return new ResponseEntity<>(joyaServ.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping ("/update/{id_modificar}")
    public ResponseEntity<Joya> editJoya (@PathVariable Long id_modificar,
                            @RequestBody Joya joya) {

        Joya nuevaJoya =  joyaServ.editJoya(id_modificar, joya);
        return new ResponseEntity<>(nuevaJoya, HttpStatus.OK);
    }
}
