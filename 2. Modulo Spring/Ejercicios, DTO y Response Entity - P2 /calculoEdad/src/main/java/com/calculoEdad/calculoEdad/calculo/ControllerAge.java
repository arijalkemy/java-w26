package com.calculoEdad.calculoEdad.calculo;

import com.calculoEdad.calculoEdad.services.ServiceAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/age")
public class ControllerAge {

    @Autowired
    ServiceAge serviceAge;

    @GetMapping("/{day}/{month}/{year}")
    public int calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        return serviceAge.calculateAgeByDate(day, month, year);
    }
}
