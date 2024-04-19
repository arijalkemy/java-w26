package com.example.concesionaria.controllers;


import com.example.concesionaria.DTOs.CarDTO;
import com.example.concesionaria.DTOs.CarResponseDTO;
import com.example.concesionaria.services.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO){

        carService.createCar(carDTO);

        return new ResponseEntity<>(carDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getCars(){
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("dates")
    public ResponseEntity<List<CarResponseDTO>> getCarsBetweenTwoDates(
            @RequestParam String since, @RequestParam String to
            ){

        return new ResponseEntity<>(carService.getCarsBetweenTwoDates(LocalDate.parse(since)
                ,LocalDate.parse(to)), HttpStatus.OK);
    }

    @GetMapping("prices")
    public ResponseEntity<List<CarResponseDTO>> getCarsBetweenTwoPrices(
            @RequestParam String since, @RequestParam String to
    ){

        return new ResponseEntity<>(carService.getCarsBetweenTwoPrices(Double.parseDouble(since)
                ,Double.parseDouble(to)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getCar(@PathVariable int id){
        return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
    }

}
