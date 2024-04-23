package org.bootcamp.concesionary.controller;

import org.bootcamp.concesionary.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
    @Autowired private IVehicleService vehicleService;

    @GetMapping("/vehicles")
    public String getVehicles() {
        return "vehicles";
    }

    @GetMapping("/vehicles/{index}")
    public 
}