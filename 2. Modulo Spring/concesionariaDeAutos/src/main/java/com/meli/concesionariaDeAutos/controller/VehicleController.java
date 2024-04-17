package com.meli.concesionariaDeAutos.controller;

import com.meli.concesionariaDeAutos.dto.VehicleDto;
import com.meli.concesionariaDeAutos.model.Vehicle;
import com.meli.concesionariaDeAutos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService service;

    @PostMapping("/")
    public void saveVehicle(@RequestBody Vehicle vehicle) {
        service.saveVehicle(vehicle);
    }

    @GetMapping("/")
    public List<VehicleDto> getVehicles() {
        return service.getVehicles();
    }

    @GetMapping("/dates")
    public List<VehicleDto> getVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        return service.getVehiclesByDate(since, to);
    }

    @GetMapping("/prices")
    public List<VehicleDto> getVehiclesByPrice(@RequestParam double since, @RequestParam double to) {
        return service.getVehiclesByPrice(since, to);
    }

    @GetMapping("/{id}")
    public VehicleDto getVehicleById(@PathVariable String id) {
        return service.getVehicleById(id);
    }
}
