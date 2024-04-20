package com.w26.covid19.controller;

import com.w26.covid19.service.IFindPersonRisk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical")
public class PersonController {

    final IFindPersonRisk findPersonRisk;

    public PersonController(IFindPersonRisk findPersonRisk) {
        this.findPersonRisk = findPersonRisk;
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getRiskPerson()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(findPersonRisk.findPersonRisk());
    }
}
