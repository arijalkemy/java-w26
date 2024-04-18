package org.example.integradorcalcularedad.controller;


import org.example.integradorcalcularedad.service.ConversorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConversorController {

   @Autowired
   private ConversorServiceImp serviceImp;

    @GetMapping("/age/{day}/{month}/{year}")
    public Integer convertAge(@PathVariable Integer day,@PathVariable Integer month,@PathVariable Integer year){
        return serviceImp.convertAge(day, month, year);
    }
}
