package com.example.ejercicios_dto_y_response_entity_vivo_parte1.controller;

import com.example.ejercicios_dto_y_response_entity_vivo_parte1.service.IAgeService;
import com.example.ejercicios_dto_y_response_entity_vivo_parte1.service.serviceImp.AgeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @Autowired
    AgeImp ageImp;

    @GetMapping("/{day}/{month}/{year}")
    public String calculateAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return ageImp.calculateAge(day, month, year);
    }

}
