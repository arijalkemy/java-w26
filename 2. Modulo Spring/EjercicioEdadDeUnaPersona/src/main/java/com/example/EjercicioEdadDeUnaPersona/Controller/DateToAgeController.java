package com.example.EjercicioEdadDeUnaPersona.Controller;

import com.example.EjercicioEdadDeUnaPersona.Service.IDateToAgeService;
import com.example.EjercicioEdadDeUnaPersona.Service.impl.DateToAgeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateToAgeController {

    @Autowired
    private IDateToAgeService dateToAgeService;

    @GetMapping("/{Dia}/{Mes}/{Ano}")
    public int DateToAgeController(@PathVariable int Dia, @PathVariable int Mes, @PathVariable int Ano) {

        return dateToAgeService.getAge(Dia,Mes,Ano);
    }
}


