package com.demospring.concesionariodeautos.controller;

import com.demospring.concesionariodeautos.dto.CarDTO;
import com.demospring.concesionariodeautos.dto.CarResponseDTO;
import com.demospring.concesionariodeautos.service.IConsecionariaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsecionariaController {
    @Autowired
    IConsecionariaServices consecionariaServices;

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody CarDTO carDTO){
        consecionariaServices.addCar(carDTO);
        return  new ResponseEntity<>("Auto añadido con exito", HttpStatus.OK);
    }

    @GetMapping(path = "/v1/api/vehicles")
    public List<CarResponseDTO> getAllCars() {
        return consecionariaServices.getCars();
    }

    @GetMapping(path = "/v1/api/vehicles")
    public List<CarResponseDTO> find(@RequestParam double since,
                       @RequestParam double to) {
        return consecionariaServices.findCarsByPrice(since, to);
    }

    @GetMapping(path = "/v1/api/vehicles")
    public List<CarResponseDTO> findCarById(@RequestParam String since,
                              @RequestParam String to) {
        return consecionariaServices.findCarsByManufacturingDate(since, to);
    }

    @GetMapping(path = "/v1/api/vehicles/{id}")
    public CarDTO findCarById(@PathVariable int id) {
        return consecionariaServices.findCarById(id);
    }

}
