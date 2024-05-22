package com.bootcamp.empresadeseguros.controller;

import com.bootcamp.empresadeseguros.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    VehiculoRepository vehiculoRepository;

    @GetMapping("/patentes")
    public List<String> getAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @GetMapping("/patenteMarca")
    public List<Object> getAllPatentesYMarca() {
        return vehiculoRepository.findPatenteYMarca();
    }

    @GetMapping("/patentes/masDeCuatroRuedas")
    public List<Object> getAllPatentesMasDeCuatroRuedas() {
        return vehiculoRepository.findPatenteMasDeCuatroRuedas();
    }
}
