package org.implementaciondb.ejercicio6_vehiculos_siniestros.controller;

import jakarta.validation.Valid;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister.SinisterRequestDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister.SinisterResponseDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.service.interfaces.ISinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinisters")
public class SinisterController {

    @Autowired
    private ISinisterService sinisterService;

    @PostMapping
    public ResponseEntity<SinisterResponseDto> createSinister(
            @RequestBody @Valid SinisterRequestDto sinisterRequestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sinisterService.saveSinister(sinisterRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<SinisterResponseDto> getSinisterById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sinisterService.findSinisterById(id));
    }

    @GetMapping("/vehicles/{vehicle_id}")
    public ResponseEntity<List<SinisterWithoutVehicleDto>> getSinisterByVehicleId(
            @PathVariable(name = "vehicle_id") Long vehicleId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(sinisterService.findSinistesrByVehicleId(vehicleId));
    }

}
