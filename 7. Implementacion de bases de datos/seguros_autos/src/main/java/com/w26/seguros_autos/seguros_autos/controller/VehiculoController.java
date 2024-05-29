package com.w26.seguros_autos.seguros_autos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.seguros_autos.seguros_autos.mediator.dto.PostVehiculo;
import com.w26.seguros_autos.seguros_autos.mediator.dto.SuccesfullyResponse;
import com.w26.seguros_autos.seguros_autos.service.IVehiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {


    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping("/new")
    public ResponseEntity<?> postVehiculo(@RequestBody PostVehiculo vehiculo) { //Faltan agregar validaciones de datos
        SuccesfullyResponse response = vehiculoService.createVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getVehiculo() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.retriveAllVehiculo());
    }


    @GetMapping("/only/patente/all")
    public ResponseEntity<?> getAllVehicleOnlyPatente() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.retrivePatenteAllVehiculo());
    }
   
    @GetMapping("/patente&marca/order_by/fecha_fabricacion")
    public ResponseEntity<?> getVehiculoPatenteAndMarca() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.retrivePatenteAndMarca());
    }
   
    @GetMapping("/patente/actual/fabricacion")
    public ResponseEntity<?> getPatenteActualFabricacion() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.retriePatenteByActualFabricacion());
    }

    @GetMapping("/patente&marca&modelo/major_perdidad_economica")
    public ResponseEntity<?> getMajorPerdidadEconomica() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.retriveMajorPerdidaEconomica());
    }
   
    @GetMapping("/majorPerdidaAndTotal")
    public ResponseEntity<?> getMajorPerdidadAndTotal() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.retriveMajorPerdidaEconomicaAndTotal());
    }
    
    
}
