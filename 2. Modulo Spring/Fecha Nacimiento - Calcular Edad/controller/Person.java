package org.example.api.controller;

import org.example.api.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Person {

    @Autowired
    IPerson iPerson;

    @GetMapping
    @RequestMapping("/{day}/{month}/{year}")
    public Long getAgePerson(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return iPerson.calculateAge(day, month, year);
    }
}

