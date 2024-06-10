package com.mercadolibre.seguro_autos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.seguro_autos.dto.ModeloDto;
import com.mercadolibre.seguro_autos.dto.PatenteMarcaDto;
import com.mercadolibre.seguro_autos.dto.PatentesDto;
import com.mercadolibre.seguro_autos.dto.SiniestroDto;
import com.mercadolibre.seguro_autos.service.IVehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    private final IVehicleService vehicleService;
    VehiclesController(IVehicleService _vehicleService)
    {
        vehicleService = _vehicleService;
    }


    @GetMapping("/get/patentes")
    public ResponseEntity<?> getAllPatentes()
    {
        return new ResponseEntity<> (
            vehicleService.getAllPatentes(),
            HttpStatus.OK
        );
    }

    @GetMapping("/get/patentes/ord")
    public ResponseEntity<List<PatenteMarcaDto>> getAllPatentesByYear()
    {
        return new ResponseEntity<> (
            vehicleService.getAllPatentesByYear(),
            HttpStatus.OK
        );
    }

    @GetMapping("/get/patentes/cuatro-ruedas/actuales")
    public ResponseEntity<List<PatentesDto>> getAllPatentesCuatroRuedasActuales()
    {
        return new ResponseEntity<> (
            vehicleService.getAllPatentesCuatroRuedasActuales(),
            HttpStatus.OK
        );
    }

    @GetMapping("/get/perdida-economica")
    public ResponseEntity<List<ModeloDto>> getAllVehiclesByPerdida()
    {
        return new ResponseEntity<> (
            vehicleService.findAllByPerdidaEconomica(),
            HttpStatus.OK
        );
    }

    @GetMapping("/get/perdida-economica/extended")
    public ResponseEntity<List<SiniestroDto>> getAllVehiclesByPerdidaExtended()
    {
        return new ResponseEntity<> (
            vehicleService.findAllByPerdidaEconomicaExtended(),
            HttpStatus.OK
        );
    }
}
