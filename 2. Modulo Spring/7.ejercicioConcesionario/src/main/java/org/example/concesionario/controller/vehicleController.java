package org.example.concesionario.controller;

import org.example.concesionario.Services.IvehicleService;
import org.example.concesionario.dto.VehicleDto;
import org.example.concesionario.dto.VehicleDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping({"/v1/api/vehicles"})
public class vehicleController {

    @Autowired
    IvehicleService vehicleService;
    
    @PostMapping({"/"})
    public void postVehicle(@RequestBody VehicleDto vehicleDto) {
        this.vehicleService.addVehicle(vehicleDto);
    }

    @GetMapping({"/"})
    @ResponseBody
    public List<VehicleDtoOut> getAllVehicles() {
        return this.vehicleService.findAllVehicles();
    }

    @GetMapping({"/dates"})
    @ResponseBody
    public List<VehicleDtoOut> getAllVehiclesByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
        return this.vehicleService.findVehiclesByDate(since, to);
    }

    @GetMapping({"/prices"})
    @ResponseBody
    public List<VehicleDtoOut> getAllVehiclesByPrice(@RequestParam int since, @RequestParam int to) {
        return this.vehicleService.findVehiclesByPrice(since, to);
    }

    @GetMapping({"/{id}"})
    @ResponseBody
    public VehicleDtoOut getVehicleById(@PathVariable int id) {
        return this.vehicleService.findVehiclesById(id);
    }
}
