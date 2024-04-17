package com.example.deportista.controller;

import com.example.deportista.model.Deporte;
import com.example.deportista.service.deporte.IDeporteService;
import com.example.deportista.service.deporte.imp.DeporteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {
    @Autowired
    private IDeporteService deporteServiceImp;
    @GetMapping
    public ResponseEntity<List<Deporte>> getDeportes() {
        return deporteServiceImp.getDeportes();
    }

    @GetMapping("/{deporte}")
    public ResponseEntity<String> getNivel(@PathVariable String deporte) {
       return deporteServiceImp.getNivel(deporte);
    }

}
