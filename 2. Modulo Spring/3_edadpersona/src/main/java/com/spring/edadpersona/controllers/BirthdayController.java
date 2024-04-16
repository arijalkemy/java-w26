package com.spring.edadpersona.controllers;

import com.spring.edadpersona.services.IBirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirthdayController {

    @Autowired
    IBirthdayService birthdayService;

    @GetMapping("{day}/{month}/{year}")
    public Integer getAge(
            @PathVariable Integer day,
            @PathVariable Integer month,
            @PathVariable Integer year
    ) {
        return birthdayService.getAge(day, month, year);
    }

}
