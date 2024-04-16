package org.miprimerproyecto.covid19vivo.controller;

import org.miprimerproyecto.covid19vivo.BD.GrupoRiesgoBD;
import org.miprimerproyecto.covid19vivo.BD.SintomaBD;
import org.miprimerproyecto.covid19vivo.DTO.GrupoRiesgo;
import org.miprimerproyecto.covid19vivo.clases.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Covid19Controller {

    @GetMapping(path = "/findSymptom")
    @ResponseBody
    public List<Sintoma> findSymptom() {
        return SintomaBD.listaSintoma;
    }

    @GetMapping(path = "/findSymptom/{name}")
    ResponseEntity<String> findSymptom( @PathVariable String name) {
        SintomaBD sintomaBD = new SintomaBD();
        int valor=sintomaBD.getSintomaByName(name);
        return new ResponseEntity<>("El sintoma "+name+" tiene un nivel de riesgo "+valor, HttpStatus.OK);
    }
    @GetMapping(path = "/findRiskPerson")
    @ResponseBody
    public List<GrupoRiesgo> findRiskPerson() {
        return GrupoRiesgoBD.findRiskPerson();
    }
}
