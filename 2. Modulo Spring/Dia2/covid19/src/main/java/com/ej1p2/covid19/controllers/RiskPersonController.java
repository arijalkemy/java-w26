package com.ej1p2.covid19.controllers;

import com.ej1p2.covid19.dto.PersonSymptomDTO;
import com.ej1p2.covid19.services.IRiskPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class RiskPersonController {

    @Autowired
    private IRiskPerson RiskPersonService;

    @GetMapping("/findRiskPerson")
    public List<PersonSymptomDTO> findRiskPerson() {
        return RiskPersonService.findRiskPersons();
    }
}
