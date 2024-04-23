package com.example.concesionaria.controller;


import com.example.concesionaria.dto.VehicleDetailDTO;
import com.example.concesionaria.dto.VehicleSummaryDTO;
import com.example.concesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService iVehicleService;

    @GetMapping("ping")
    public ResponseEntity<String> pingPong(){
        return ResponseEntity.ok("Pong");
    }

    @PostMapping
    public ResponseEntity<Integer> createVehicle(@RequestBody VehicleDetailDTO vehicleDetailDTO){
        return ResponseEntity.ok(iVehicleService.createVehicle(vehicleDetailDTO)) ;
    }

    @GetMapping
    public ResponseEntity<List<VehicleSummaryDTO>> getAllVehiclesSummary(){
        return ResponseEntity.ok(iVehicleService.getAllVehiclesSummary());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDetailDTO>> getAllVehiclesVyDate(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(iVehicleService.getAllVehiclesByDate(Integer.parseInt(since), Integer.parseInt(to)));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDetailDTO>> getAllVehiclesByPrice(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(iVehicleService.getAllVehiclesByPrice(Double.parseDouble(since), Double.parseDouble(to)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDetailDTO> getVehicleById(@PathVariable Integer id){



        return ResponseEntity.ok(iVehicleService.getAllVehicleById(id));
    }


}
