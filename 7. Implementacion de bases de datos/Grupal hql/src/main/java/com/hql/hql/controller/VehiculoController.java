package com.hql.hql.controller;

import com.hql.hql.DTO.VehiculoPatenteMarcaDTO;
import com.hql.hql.model.Vehiculo;
import com.hql.hql.service.IVehiculoService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<?> getPatentesVehiculos() {
        return new ResponseEntity<>(vehiculoService.findLicensePlate(), HttpStatus.OK);
    }

    @GetMapping("/patenteMarca")
    public ResponseEntity<?> getPatentesAndMarcaVehiculos() {
        return new ResponseEntity<>(vehiculoService.findPatenteMarcaInOrder(), HttpStatus.OK);
    }

    @GetMapping("/patenteAnio")
    public ResponseEntity<?> getPatentesByAnio() {
        return new ResponseEntity<>(vehiculoService.findLicenseByCurrentYear(), HttpStatus.OK);
    }
}
