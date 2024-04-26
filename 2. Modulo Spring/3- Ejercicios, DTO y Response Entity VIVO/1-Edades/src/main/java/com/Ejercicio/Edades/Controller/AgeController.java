package com.Ejercicio.Edades.Controller;

import com.Ejercicio.Edades.Service.BirthToAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AgeController")
public class AgeController {
    @Autowired
    BirthToAge birthToAge;

    @GetMapping(path = "/year/{day}/{month}/{year}")
    public Integer birthToAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        return  birthToAge.birthToAge(day, month, year);
    }
}
