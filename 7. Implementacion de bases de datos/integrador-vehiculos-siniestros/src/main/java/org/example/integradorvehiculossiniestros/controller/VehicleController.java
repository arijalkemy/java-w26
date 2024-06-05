package org.example.integradorvehiculossiniestros.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.integradorvehiculossiniestros.entity.dto.VehicleRequestDTO;
import org.example.integradorvehiculossiniestros.service.IVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> createVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        vehicleService.saveVehicle(vehicleRequestDTO);
        return ResponseEntity.ok("Vehicle saved!");
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/plate")
    @ResponseBody
    public ResponseEntity<?> getAllVehiclePlates(){
        return ResponseEntity.ok(vehicleService.getAllPlates());
    }

    @GetMapping("/plate/brand")
    @ResponseBody
    public ResponseEntity<?> getAllPlatesBrandOrderedByDate(){
        return ResponseEntity.ok(vehicleService.getAllPlatesBrandOrderedByDate());
    }

    @GetMapping("/plate/year")
    @ResponseBody
    public ResponseEntity<?> getAllPlatesByWheelsAndYear(){
        return ResponseEntity.ok(vehicleService.getAllPlatesByWheelsAndYear());
    }

    @GetMapping("/plate/accident")
    @ResponseBody
    public ResponseEntity<?> getAllDetailsByAccident(){
        return ResponseEntity.ok(vehicleService.getAllDetailsByAccident());
    }

    @GetMapping("/money/total")
    @ResponseBody
    public ResponseEntity<?> getTotalMoneyLoss(){
        return ResponseEntity.ok(vehicleService.getTotalMoneyLoss());
    }

}
