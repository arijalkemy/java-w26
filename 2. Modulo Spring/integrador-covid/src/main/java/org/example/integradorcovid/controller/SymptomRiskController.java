package org.example.integradorcovid.controller;


import org.example.integradorcovid.dto.SymptomRiskDTO;
import org.example.integradorcovid.model.Symptom;
import org.example.integradorcovid.service.impl.SymptomRiskImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SymptomRiskController {

    private final SymptomRiskImp symptomRiskImp;

    @Autowired
    public SymptomRiskController(SymptomRiskImp symptomRiskImp){
        this.symptomRiskImp = symptomRiskImp;
    }


    @GetMapping("/symptom/findSymptom")
    @ResponseBody
    public ResponseEntity<List<Symptom>> findSymptom(){
        return new ResponseEntity<>(symptomRiskImp.findAll(), HttpStatus.OK);

    }



    @GetMapping("/symptom/findSymptom/{name}")
    @ResponseBody
    public ResponseEntity<Symptom> findSymptom(@PathVariable String name){
        return new ResponseEntity<>(symptomRiskImp.find(name), HttpStatus.OK);
    }


    @GetMapping("/symptom/findRiskPerson/")
    @ResponseBody
    public ResponseEntity<List<SymptomRiskDTO>> findRiskPerson(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Estado","Resultado de la solicitud");
        return new ResponseEntity<>(symptomRiskImp.findRelated(), HttpStatus.OK);
    }

}
