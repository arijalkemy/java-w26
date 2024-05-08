package com.bootcamp.concesionariadeautos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehiclesController {

    @PostMapping
    public EntityResponse<?> Post(){

    }

    @GetMapping
    public EntityResponse<?> GetAll(){

    }

}
