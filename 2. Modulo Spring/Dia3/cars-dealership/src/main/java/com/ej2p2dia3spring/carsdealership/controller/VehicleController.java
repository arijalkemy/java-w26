package com.ej2p2dia3spring.carsdealership.controller;

import com.ej2p2dia3spring.carsdealership.dto.VehicleDTO;
import com.ej2p2dia3spring.carsdealership.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    @Autowired
    private IVehicleService vehicleService;

    @PostMapping("/")
    public void addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.addVehicle(vehicleDTO);
    }

    @GetMapping("/")
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/dates/")
    public List<VehicleDTO> getVehiclesByManufacturingDate(@RequestParam String since, @RequestParam String to) {
        return vehicleService.getVehiclesByManufacturingDate(since, to);
    }

    @GetMapping("/prices/")
    public List<VehicleDTO> getVehiclesByPrice(@RequestParam String since, @RequestParam String to) {
        return vehicleService.getVehiclesByPrice(Integer.parseInt(since), Integer.parseInt(to));
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable int id) {
        return vehicleService.getVehicleById(id);
    }
}
