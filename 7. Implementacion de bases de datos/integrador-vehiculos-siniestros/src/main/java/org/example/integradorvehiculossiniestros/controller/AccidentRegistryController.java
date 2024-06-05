package org.example.integradorvehiculossiniestros.controller;

import lombok.RequiredArgsConstructor;
import org.example.integradorvehiculossiniestros.entity.dto.AccidentRegistryRequestDTO;
import org.example.integradorvehiculossiniestros.entity.dto.VehicleRequestDTO;
import org.example.integradorvehiculossiniestros.service.IAccidentRegistryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accident")
@RequiredArgsConstructor
public class AccidentRegistryController {

    private final IAccidentRegistryService accidentRegistryService;

    @PostMapping("/{vehicleId}")
    @ResponseBody
    public ResponseEntity<?> createAccidentRegistry(
            @PathVariable Integer vehicleId,
            @RequestBody AccidentRegistryRequestDTO accidentRegistryRequestDTO){
        accidentRegistryService.saveAccidentRegistry(vehicleId, accidentRegistryRequestDTO);
        return ResponseEntity.ok("Accident Registry Saved!");
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllVehicles(){
        return ResponseEntity.ok(accidentRegistryService.getAllAccidentRegistry());
    }
}
