package com.practicaSpring.concesionariaDeAutos.controller;

import com.practicaSpring.concesionariaDeAutos.dto.CarInputDTO;
import com.practicaSpring.concesionariaDeAutos.dto.CarResponseDTO;
import com.practicaSpring.concesionariaDeAutos.model.Car;
import com.practicaSpring.concesionariaDeAutos.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {
    @Autowired
    ICarService carService;

    @PostMapping()
    public void registerCar(@RequestBody CarInputDTO car){
        carService.addCar(car);
    }

    @GetMapping()
    public ResponseEntity<List<CarResponseDTO>> getCars(){
        List<CarResponseDTO> dtos = carService.getCarDTOs();
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<CarResponseDTO>> getCarsInDateRange(@RequestParam LocalDate from, @RequestParam LocalDate to){
        List<CarResponseDTO> dtos = carService.getCarDTOsForDateRange(from, to);
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarResponseDTO>> getCarInPriceRange(@RequestParam Integer from, @RequestParam Integer to){
        List<CarResponseDTO> dtos = carService.getCarDTOsForPriceRange(from, to);
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Car resp = carService.getCarById(id);
        if(resp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resp);
    }
}
