package org.miprimerproyecto.consesionariaautos.controller;

import org.miprimerproyecto.consesionariaautos.dto.VehicleDTO;
import org.miprimerproyecto.consesionariaautos.model.Vehicle;
import org.miprimerproyecto.consesionariaautos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/api/vehicles")
    public String addVehicle(@RequestBody VehicleDTO vehicle) {
        vehicleService.createVehicle(vehicle);
        return "Vehiculo creado correctamente";
    }

    @GetMapping("/api/vehicles")
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getVehicules();
    }

    @GetMapping("/api/vehicles/dates/{date}")
    public List<VehicleDTO> getVehiclesByDate(@PathVariable String date) {
        return vehicleService.getVehiculeByDate(date);
    }
    @GetMapping("/api/vehicles/prices/{minPrice}/{maxPrice}")
    public List<VehicleDTO> getVehiclesByPrice(@PathVariable int minPrice, @PathVariable int maxPrice) {
        return vehicleService.getVehiculeByRangePrice(minPrice, maxPrice);
    }

    @GetMapping("/api/vehicles/{id}")
    public VehicleDTO getVehicleById(@PathVariable int id) {
        return vehicleService.getVehiculeById(id);
    }
}
