package com.javabootcamp.linktracker.controller;

import com.javabootcamp.linktracker.DTO.CargaLinkDTO;
import com.javabootcamp.linktracker.DTO.MensajeDTO;
import com.javabootcamp.linktracker.service.Impl.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    @Autowired
    ILinkService linkservice;
    @PostMapping("/link")
    ResponseEntity<MensajeDTO> crearLink(@RequestBody CargaLinkDTO nuevoLink){
     return new ResponseEntity<MensajeDTO>(linkservice.cargarLink(nuevoLink), HttpStatus.CREATED);
    }
    @GetMapping("/link/{id}")
    RedirectView redireccionar(@PathVariable int id , @RequestParam(value = "password") String password){
        return new RedirectView(linkservice.redireccionar(id,password));
    }
    @PatchMapping("/invalidate/{linkID}")
    ResponseEntity<MensajeDTO> invalidadLink(@PathVariable int linkID, @RequestParam(value = "password") String password)
    {
        return new ResponseEntity<MensajeDTO>(linkservice.invalidarLink(linkID,password),HttpStatus.ACCEPTED);
    }







}
