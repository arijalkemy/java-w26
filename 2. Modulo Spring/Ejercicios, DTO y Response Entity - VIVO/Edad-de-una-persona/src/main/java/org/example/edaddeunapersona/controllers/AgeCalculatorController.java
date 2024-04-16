package org.example.edaddeunapersona.controllers;

import org.example.edaddeunapersona.services.IGetAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AgeCalculatorController {

    @Autowired
    IGetAgeService ageService;

    @GetMapping("/{day}/{month}/{year}")
    public long getAge(@PathVariable int day,
                       @PathVariable int month,
                       @PathVariable int year) {
        //call to service
        return ageService.getAge(day, month, year);

    }
}
