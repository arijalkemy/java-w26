package com.mercadolibre.hqltest.controller;


import com.mercadolibre.hqltest.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    IActorService service;

    @GetMapping("/")
    private ResponseEntity<?> findAllActors(){
        return new ResponseEntity<>(service.findAllActors(), HttpStatus.OK);
    }

}
