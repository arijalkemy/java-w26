package org.example.ejercicio_concesionario.controllers;

import jakarta.websocket.server.PathParam;
import org.example.ejercicio_concesionario.dto.CarRequestDTO;
import org.example.ejercicio_concesionario.services.ICarDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("v1/api/vehicles")
public class CarDealershipController {
    @Autowired
    ICarDealershipService carDealershipService;

    @PostMapping("/")
    public ResponseEntity<?> postCar(@RequestBody CarRequestDTO car){
        return ResponseEntity.ok(carDealershipService.addCar(car));
    }

    @GetMapping("/")
    public ResponseEntity<?>getAllVehicles(){
        return ResponseEntity.ok(carDealershipService.getAllCars());
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesByDateRange (@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
                                                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to){
        return ResponseEntity.ok(carDealershipService.getCarsByDateRange(since, to));
    }
    @GetMapping("/prices")
    public ResponseEntity<?> getVehiclesByPriceRange (@RequestParam Double since, @RequestParam Double to){
        return ResponseEntity.ok(carDealershipService.getCarsByPriceRange(since,to));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById (@PathVariable Long id){
        return ResponseEntity.ok(carDealershipService.getCarById(id));
    }
}
