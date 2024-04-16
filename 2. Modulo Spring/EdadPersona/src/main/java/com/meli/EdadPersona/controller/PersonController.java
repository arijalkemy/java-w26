package com.meli.EdadPersona.controller;

import com.meli.EdadPersona.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonController {

    @Autowired
    private IPersonService service;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(@PathVariable int day, @PathVariable int month, @PathVariable  int year){
        return new ResponseEntity<>(service.getAge(day, month, year), HttpStatus.OK);
    }
}
