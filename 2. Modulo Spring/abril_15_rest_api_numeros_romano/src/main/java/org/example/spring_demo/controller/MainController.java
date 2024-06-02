package org.example.spring_demo.controller;

import org.example.spring_demo.service.IRomanNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    final IRomanNumberService romanNumberService;

    public MainController(IRomanNumberService _romanNumberService)
    {
        romanNumberService = _romanNumberService;
    }

    @GetMapping("/{param}")
    public ResponseEntity<String> getMain(@PathVariable String param){
        return new ResponseEntity<>(
                romanNumberService.getRomanNumber(param),
                HttpStatus.OK
        );
    }
}
