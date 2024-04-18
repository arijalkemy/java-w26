package com.ejerciciospring.concesionario.controller;

import com.ejerciciospring.concesionario.dto.CarInputDTO;
import com.ejerciciospring.concesionario.dto.CarOutputDTO;
import com.ejerciciospring.concesionario.models.Car;
import com.ejerciciospring.concesionario.service.IConcesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
public class CarController {
    @Autowired
    private IConcesionService concesionService;

    @PostMapping("v1/api/vehiculos")
    public void saveCar(@RequestBody CarInputDTO car) {
        concesionService.saveCar(car);
    }
    @GetMapping("v1/api/vehiculos")
    public List<CarOutputDTO> getAllCars() {
       return concesionService.getCarsWithoutServices();
    }
    @GetMapping("v1/api/vehiculos/{id}")
    public Car getCarById(@PathVariable Integer id) {
        return concesionService.getCarById(id);
    }
    @GetMapping("v1/api/vehiculos/dates")
    public List<CarOutputDTO> getCarsByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return concesionService.getCarsByDate(since,to);
    }
    @GetMapping("v1/api/vehiculos/prices")
    public List<CarOutputDTO> getCarsByPrice(@RequestParam Double since, @RequestParam Double to){
        return concesionService.getCarsByPrice(since,to);
    }
}

