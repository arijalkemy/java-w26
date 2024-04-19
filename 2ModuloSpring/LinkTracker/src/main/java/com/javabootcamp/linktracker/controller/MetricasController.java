package com.javabootcamp.linktracker.controller;

import com.javabootcamp.linktracker.model.DTO.MensajeDTO;
import com.javabootcamp.linktracker.model.DTO.RedirectDTO;
import com.javabootcamp.linktracker.repository.LinkRepository;
import com.javabootcamp.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricasController {
    @Autowired
    ILinkService linkService;
    @GetMapping("/metrics/{id}")
    public ResponseEntity<MensajeDTO> obtenerMetricasPorId(@PathVariable Integer id, @RequestParam(value="password") String pasword){
       return  new ResponseEntity<MensajeDTO>( linkService.obtenerMetricas(id, pasword), HttpStatus.ACCEPTED);
    }
}
