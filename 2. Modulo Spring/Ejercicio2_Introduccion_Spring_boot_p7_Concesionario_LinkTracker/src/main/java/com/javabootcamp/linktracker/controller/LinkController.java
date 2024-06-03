package com.javabootcamp.linktracker.controller;

import com.javabootcamp.linktracker.model.DTO.CargaLinkDTO;
import com.javabootcamp.linktracker.model.DTO.MensajeDTO;
import com.javabootcamp.linktracker.model.Link;
import com.javabootcamp.linktracker.repository.ILinkRepository;
import com.javabootcamp.linktracker.repository.LinkRepository;
import com.javabootcamp.linktracker.service.ILinkService;
import com.javabootcamp.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.PreparedStatement;

@RestController
public class LinkController {
    @Autowired
    ILinkService linkservice;
    @PostMapping("/link")
    ResponseEntity<MensajeDTO> crearLink(@RequestBody CargaLinkDTO nuevoLink){
     return new ResponseEntity<MensajeDTO>(linkservice.cargarLink(nuevoLink), HttpStatus.CREATED);
    }
    @GetMapping("/link/{id}")
    RedirectView redireccionar(@PathVariable int id){
        return new RedirectView(linkservice.redireccionar(Integer.valueOf(id)));
    }
}
