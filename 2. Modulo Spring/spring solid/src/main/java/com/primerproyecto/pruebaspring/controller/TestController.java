package com.primerproyecto.pruebaspring.controller;

import com.primerproyecto.pruebaspring.service.ITestService;
import com.primerproyecto.pruebaspring.service.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludos")
public class TestController {

    @Autowired
    ITestService testService;

    @GetMapping("/test/{name}")
    public String saludo(@PathVariable String name ){
        return testService.saludar(name);
    }
}
