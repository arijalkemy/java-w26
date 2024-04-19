package com.example.link.controladores;


import com.example.link.DTOs.MetricResponseDTO;
import com.example.link.servicios.interfaces.ILinkServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricController {

    @Autowired
    ILinkServicio linkServicio;

    @GetMapping("/{linkId}")
    public ResponseEntity<MetricResponseDTO> getMetricsFrom(@PathVariable int linkId) {
        return new ResponseEntity<>(linkServicio.getMetricsFrom(linkId), HttpStatus.OK);
    }


}
