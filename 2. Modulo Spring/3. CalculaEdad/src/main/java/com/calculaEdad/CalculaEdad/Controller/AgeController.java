package com.calculaEdad.CalculaEdad.Controller;

import com.calculaEdad.CalculaEdad.Service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    @Autowired
    AgeService ageService;

    @GetMapping("/calcula/{day}/{month}/{year}")
    public Integer calculaEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year ){
        return ageService.calculaEdad(day, month, year);
    }
}
