package com.example.ejercicios_dto_y_response_entityvivo.controller;

import com.example.ejercicios_dto_y_response_entityvivo.DTO.ResponseDTO;
import com.example.ejercicios_dto_y_response_entityvivo.service.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ageController {
    @Autowired
    IAgeService ageService;

    @GetMapping("/{day}/{month}/{year}")
    ResponseEntity<ResponseDTO> calculateAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        return new ResponseEntity<>(ageService.calculateAge(day,month,year), HttpStatus.OK);
    }
}
