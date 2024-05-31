package com.example.dto_y_response_entityp2.controller;

import com.example.dto_y_response_entityp2.dto.PersonDTO;
import com.example.dto_y_response_entityp2.dto.SymptomsDto;
import com.example.dto_y_response_entityp2.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HospitalController {
    @Autowired
    IHospitalService hospitalService;


    @GetMapping("/findSymptom")
    ResponseEntity<List<SymptomsDto>> getAllSymptoms(){
        return  new ResponseEntity<>(hospitalService.getAllSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<SymptomsDto> searchSymptom(@PathVariable String name){
        return  new ResponseEntity<>(hospitalService.getSymptom(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<List<PersonDTO>> searchSymptom(){
        return  new ResponseEntity<>(hospitalService.getRiskPersons(), HttpStatus.OK);
    }




}
