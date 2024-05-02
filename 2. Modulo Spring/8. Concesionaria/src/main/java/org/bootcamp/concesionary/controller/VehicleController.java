package org.bootcamp.concesionary.controller;

import org.bootcamp.concesionary.dto.VehicleDTO;
import org.bootcamp.concesionary.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {
    @Autowired private IVehicleService vehicleService;

    @PostMapping("/")
    public String addVehicle(@RequestBody VehicleDTO vehicleDTO){
        return vehicleService.addVehicle(vehicleDTO);
    }

    @GetMapping("/")
    public List<VehicleDTO> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable String id){
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("/dates")
    public List<VehicleDTO> getVehiclesBetweenDates(@RequestParam String since, @RequestParam String to){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sinceDate = formatter.parse(since);
            Date toDate = formatter.parse(to);
            return vehicleService.getVehiclesBetweenDates(sinceDate, toDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'yyyy-MM-dd'.");
        }
    }

    @GetMapping("/prices")
    public List<VehicleDTO> getVehiclesBetweenPrices(@RequestParam Integer since, @RequestParam Integer to){
        return vehicleService.getVehiclesBetweenPrices(since, to);
    }
}