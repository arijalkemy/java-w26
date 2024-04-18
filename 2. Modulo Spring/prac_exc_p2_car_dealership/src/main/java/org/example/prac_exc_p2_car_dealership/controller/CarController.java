package org.example.prac_exc_p2_car_dealership.controller;

import org.example.prac_exc_p2_car_dealership.dto.FullVehicleDTO;
import org.example.prac_exc_p2_car_dealership.dto.SimpleVehicleDTO;
import org.example.prac_exc_p2_car_dealership.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {
    @Autowired
    IVehicleService vehicleService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<String> addVehicle(@RequestBody FullVehicleDTO vehicleData) {
        try {
            Integer newVehicleId = vehicleService.addVehicle(vehicleData);
            return new ResponseEntity<>("Vehiculo creado con id: "+newVehicleId, HttpStatus.OK);
        } catch (Exception e) {
            e.getCause();
            return new ResponseEntity<>("Error al agregar vehiculo", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/")
    @ResponseBody
    public List<SimpleVehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/dates")
    @ResponseBody
    public List<SimpleVehicleDTO> getVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        return vehicleService.getVehiclesByDate(since, to);
    }

    @GetMapping("/prices")
    @ResponseBody
    public List<SimpleVehicleDTO> getVehiclesByPrice(@RequestParam String since, @RequestParam String to) {
        return vehicleService.getVehiclesByPrice(since, to);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public FullVehicleDTO getVehicleById(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }
}
