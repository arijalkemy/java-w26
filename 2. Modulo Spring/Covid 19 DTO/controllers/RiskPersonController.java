package org.example.api.controllers;

import org.example.api.entities.dto.RiskPersonDTO;
import org.example.api.services.IRiskPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/riskPerson")
public class RiskPersonController {
    private final IRiskPerson iRiskPerson;

    public RiskPersonController(@Autowired IRiskPerson iRiskPerson) {
        this.iRiskPerson = iRiskPerson;
    }

    @GetMapping
    public ResponseEntity<List<RiskPersonDTO>> findRiskPerson() {
        return ResponseEntity.ok().body(this.iRiskPerson.findRiskPerson());
    }
}
