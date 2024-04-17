package com.meliBootcamp.restdto.controllers;

import com.meliBootcamp.restdto.servicies.interfaces.IAges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AgesController {

    @Autowired
    IAges ages;

    @GetMapping("/{year}/{month}/{day}")
    public Integer edad(@PathVariable Integer year,@PathVariable Integer month,@PathVariable Integer day){
        return ages.betwenAges(year,month,day);
    }
}
