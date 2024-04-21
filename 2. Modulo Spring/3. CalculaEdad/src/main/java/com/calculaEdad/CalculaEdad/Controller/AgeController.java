package com.calculaEdad.CalculaEdad.Controller;

import com.calculaEdad.CalculaEdad.Service.AgeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    @Autowired
    AgeServiceImpl ageServiceImpl;

    @GetMapping("/calcula/{day}/{month}/{year}")
    public Integer calculaEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year ){
        return ageServiceImpl.calculaEdad(day, month, year);
    }
}
